from flask import Flask, send_from_directory
from utils import db_util
from gevent import pywsgi

app = Flask(__name__)


# 获取数据库Excel文档接口
@app.route('/api/dev/db/docs', methods=['GET'])
def get_db_docs():
    # 生成数据库文档
    conf_info = db_util.generate_docs()
    # 返回文件流
    return send_from_directory(conf_info['save_path'], filename=conf_info['save_name'],
                               as_attachment=True)


@app.route('/')
def hello_world():
    return 'Hello World!'


if __name__ == '__main__':
    server = pywsgi.WSGIServer(('0.0.0.0', 8080), app)
    server.serve_forever()
