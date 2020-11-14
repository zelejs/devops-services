import pymysql
import os

# 数据库信息定义
from utils.excel_util import write_excel

db_info = {
    'host': os.getenv('MYSQL_HOST') or "localhost",
    'port': int(os.getenv('MYSQL_PORT')) if os.getenv('MYSQL_PORT') else 3306,
    'user': os.getenv('MYSQL_USER') or "root",
    'password': os.getenv('MYSQL_PASSWORD') or "root",
    'database': os.getenv('MYSQL_DATABASE') or "test",
    'charset': os.getenv('MYSQL_CHARSET') or "utf8",
    'save_path': os.getenv('SAVE_PATH') or "d:/desktop/",
    'save_name': os.getenv('SAVE_NAME') or "db.xlsx",
    'table_head': ("字段名", "数据类型", "备注")
}
# 显示数据表SQL语句
show_tables_sql = "show tables"
# 显示数据表结构SQL语句
desc_tables_sql = "select COLUMN_NAME,DATA_TYPE,ifnull(ifnull(CHARACTER_MAXIMUM_LENGTH,NUMERIC_PRECISION),''), COLUMN_COMMENT from information_schema.columns where table_schema = '%s' and table_name = '%s'"
# 忽略字段
ignore_field = ['text', 'bigint']


def get_connection(host, port, user, password, database, charset="utf8"):
    connection = pymysql.Connect(host=host, port=port, user=user, passwd=password, db=database,
                                 charset=charset)
    connection.autocommit(True)
    return connection


def generate_docs():
    connection = get_connection(db_info['host'], db_info['port'], db_info['user'],
                                db_info['password'], db_info['database'],
                                db_info['charset'])
    # 获取游标
    cursor = connection.cursor()
    # 查询数据库的表
    cursor.execute(show_tables_sql)
    contentList = []
    for each in cursor.fetchall():
        table_name = each[0]
        desc_table = desc_tables_sql % (db_info['database'], table_name)
        cursor.execute(desc_table)
        table_t = (str(table_name + "表"), '', '')
        contentList.append(table_t)
        contentList.append(db_info['table_head'])
        for r in cursor.fetchall():
            result = (r[0], str(
                r[1] + ('(' + r[2] + ')' if (r[1] not in ignore_field and r[2] != '') else '')),
                      r[3])
            contentList.append(result)
        contentList.append(('', '', ''))
    try:
        write_excel('%s数据库' % db_info['database'], db_info['save_path'] + "/" + db_info['save_name'],
                    contentList)
    except Exception as e:
        print("Reason:", e)

    return db_info
