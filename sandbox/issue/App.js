
var express = require("express");
var app = express();
var fs = require("fs");
var path = require("path");
var shell = require("shelljs");

module.exports = require("./config.js");

const checkJsonFilePath = "./check.json";
const IssueService = require('./service/IssueService');
const bodyParser = require("body-parser");
const { exit } = require("process");
app.use(bodyParser.urlencoded({ extended: false }))
app.use(bodyParser.json());


// Issue数据库记录表
class Issue {
  constructor(title, brief, module_name, status, type, priority) {
    // Default values defined according to issue API
    const defaults = {
      title: 'default',
      brief: '',
      module_name: '',
      status: 'Open',
      type: '11',
      priority: '1',
    }; 

    // 缺陷标题
    this.title = title || defaults.title;
    // 缺陷简要
    this.brief = brief || defaults.brief;
    // 缺陷模块
    this.module_name = module_name || defaults.module_name;
    // 当前状态
    this.status = status || defaults.status;
    // 缺陷类型
    this.type = type || defaults.type;
    // 优先级
    this.priority = priority || defaults.priority;
  }
}

app.all("*", function (req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header(
    "Access-Control-Allow-Headers",
    "Content-Type,Content-Length, Authorization, Accept,X-Requested-With"
  );
  res.header("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
  res.header("Access-Control-Allow-Credentials", true);
  res.header("X-Powered-By", " 3.2.1");
  if (req.method == "OPTIONS") res.send(200);
  /*让options请求快速返回*/ else next();
});

/*
 *  crudless检查接口:/api/issue/
 * 根据固定yamlDir文件夹路径与swagger文件夹路径进行检查
*/
app.get("/api/issue/check", function (req, res) {
  // 查找yaml文件
  let result = shell.exec("ls " + yamlDir + "| grep -E \"(.yml|.yaml)$\"");
  // yaml文件名集合
  var arr = result.split("\n");
  arr.splice(-1, 1);
  // 缺陷记录集合
  var issueRecords = [];
  arr.forEach(item => {
    console.log("crudless -f " + yamlDir + "/" + item +" --swagger " + swaggerDir)
    // 生成检查结果
    shell.exec("crudless -f " + yamlDir + "/" + item +" --swagger " + swaggerDir);
    // 获取结果
    var checkJson = getCheckJson();
    Object.keys(checkJson).forEach(modelName => {
      // 处理详细字段（fileds and api）
      Object.keys(checkJson[modelName]).forEach(key => {
        key = key.toLowerCase();
        var title = (key == 'fields' ? "后台缺少字段" : (key == 'api' ? "后台缺少API" : null));
        Object.keys(checkJson[modelName][key]).forEach(brief => {
          // 生成issue
          issueRecords.push(new Issue(title, JSON.stringify(checkJson[modelName][key][brief]), modelName, null, null, null)); 
        })
      })
    })
  })
  issueRecords.forEach(item => IssueService.addIssue(item));
  clearCheckJson();
  message = {
    code: 200,
    message: issueRecords,
  };
  res.send(message);
});


// 获取检查结果文件内容 并以JSON形式返回
function getCheckJson() {
  return JSON.parse(fs.readFileSync(checkJsonFilePath, "utf-8").toString());
}

// 清空检查结果文件
function clearCheckJson() {
  shell.exec("> " + checkJsonFilePath);
}

var server = app.listen(8080, function () {
  var host = this.address().address;
  var port = this.address().port;
  host = (host == "::" ? "localhost" : host);
  console.log("应用实例，访问地址为 http://%s:%s", host, port);
});