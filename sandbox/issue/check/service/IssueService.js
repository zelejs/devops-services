var mysql = require("mysql");
module.exports = require("../config.js");
var connection = mysql.createConnection(dbInfo);
var table = "cr_issue_task";

module.exports = {
  addIssue: function(issue) {
    // var addSql = 'INSERT INTO ' + table + ' (title,brief,module_name,status,type,priority) VALUES(?,?,?,?,?,?)';
    var addSql = 'INSERT INTO ' + table + ' SET ?';
    console.log(issue);
    connection.query(addSql, issue, function (err, result) {
      if(err){
        console.log('[INSERT ERROR] - ',err.message);
        return;
      }        
      console.log('--------------------------INSERT----------------------------');
      console.log('INSERT ID:',result);        
      console.log('-----------------------------------------------------------------\n\n');  
    });
  }
}