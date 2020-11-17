var mysql = require("mysql");
module.exports = require("../config.js");
var connection = mysql.createConnection(dbInfo);
var table = "cr_issue_task";

module.exports = {
  addIssue: function(issue) {
    // var addSql = 'INSERT INTO ' + table + ' (title,brief,module_name,status,type,priority) VALUES(?,?,?,?,?,?)';
    var addSql = 'IF NOT EXITIS (SELECT * FROM '+ table +' WHERE brief=? AND module_name=?) THEN INSERT INTO ' + table + ' SET ?';
    console.log(issue);
    connection.query(addSql, [issue.brief, issue.module_name, issue], function (err, result) {
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

function handleDisconnect() {
  connection = mysql.createConnection(dbInfo); // Recreate the connection, since
                                                  // the old one cannot be reused.
  connection.connect(function(err) {              // The server is either down
    if(err) {                                     // or restarting (takes a while sometimes).
      console.log('error when connecting to db:', err);
      setTimeout(handleDisconnect, 2000); // We introduce a delay before attempting to reconnect,
    }                                     // to avoid a hot loop, and to allow our node script to
  });                                     // process asynchronous requests in the meantime.
                                          // If you're also serving http, display a 503 error.
  connection.on('error', function(err) {
    console.log('db error', err);
    if(err.code === 'PROTOCOL_CONNECTION_LOST') { // Connection to the MySQL server is usually
      handleDisconnect();                         // lost due to either server restart, or a
    } else {                                      // connnection idle timeout (the wait_timeout
      throw err;                                  // server variable configures this)
    }
  });
}

handleDisconnect();