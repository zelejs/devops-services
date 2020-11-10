// yaml文件夹路径
yamlDir = "/var/yaml";
// swagger文件夹路径
swaggerDir = "/var/swagger";
// 数据库信息
dbInfo = {     
  host     : process.env.MYSQL_HOST,       
  user     : process.env.MYSQL_USER,              
  password : process.env.MYSQL_PASSWORD,       
  port     : process.env.MYSQL_PORT,                   
  database : process.env.MYSQL_DB
}