
function genSQl(tableName, fields) {
  const unique = [];
  let fieldList = [...fields];
  const idIndex = fieldList.findIndex(field => field.field === 'id');
  let idComment = '主键id';
  let idType = 'bigint(20)';

  if (idIndex > -1) {
    const idField = fieldList.splice(idIndex, 1).shift();
    if (idField && idField.comment) {
      idComment = idField.comment;
    }
    if (idField && idField.type) {
      idType = idField.type;
    }
  }
  const sqlContent = [
    "`id` " + idType + " NOT NULL AUTO_INCREMENT COMMENT '" + idComment + "'",
    ...genSQLFields(fieldList, unique),
    "PRIMARY KEY (`id`)",
    unique.length ?
      `UNIQUE (${unique.map(f => "`" + f + "`").join(',')})`
      : '',
  ].filter(s => s).join(', \n  ');

  return "DROP TABLE IF EXISTS `" + tableName + "`;\n" +
    "CREATE TABLE `" + tableName + "` (\n  "
    + sqlContent +
    "\n) ENGINE=InnoDB DEFAULT CHARSET=utf8;";
}

function genSQLFields(fields, unique) {
  return fields.map(field => {
    const orderList = ['field', 'type', 'notnull', 'default', 'unique', 'comment'];
    const typeMap = {
      field: v => "`" + upperCaseToUnderLine(v) + "`",
      type: v => v,
      default: v => `DEFAULT '${v}'`,
      unique: v => void unique.push(field.field),
      notnull: v => v ? 'NOT NULL' : '',
      comment: v => `COMMENT '${v}'`,
    };

    return orderList.map(key => {
      return field[key] ? typeMap[key](field[key]) : '';
    }).join(' ').replace(/\s{2,}/g, ' ');
  })
}

function upperCaseToUnderLine(value) {
  return value.replace(/[a-z]+[A-Z]{1}/g, s =>
    s.replace(/[A-Z]/g, u => `_${u.toLowerCase()}`)
  )
}

function yamlToSQL(data) {
  const { cg, fields } = data;
  const { master } = cg;
  const fieldsFormat = [];

  Object.keys(fields).forEach(field => {
    const { sql } = fields[field];

    if (sql) {
      fieldsFormat.push({
        field,
        ...sql,
      });
    }
  })

  return genSQl(master, fieldsFormat);
}

function yamlToReportSQL(pageName, yamlData, sqlData) {
  const { data } = yamlData;
  const { type, search, tips } = data;


  return `INSERT INTO \`st_statistics_meta\` (
  \`field\`,
  \`query_sql\`,
  \`type\`,
  \`search\`,
  \`tips\`
)
VALUES
  (
    ${pageName ? `'${pageName}'` : 'NULL'},
    ${sqlData ? `'${sqlData.replace(/\'/g, '\\\'')}'` : 'NULL'},
    ${type ? `'${type}'` : 'NULL'},
    ${search ? `'${search}'` : 'NULL'},
    ${tips ? `'${tips}'` : 'NULL'},
  ); `
}

function yamlToConfigSQL(groupName, groupData) {
  const { items } = groupData;
  return `INSERT INTO \`t_config_field_group\` ( \`pid\`, \`lang\`, \`name\`, \`comment\`, \`sort\`, \`type\`, \`org_id\`) 
VALUES ( NULL, 'zh', '${groupData.name}', '${groupData.description}', NULL, 'CONFIG', '100000000000000010');

set @groupNameGroupId = @@identity;

${items.map(item => {
    return `INSERT INTO \`t_config_field\` ( \`field\`, \`group_id\`, \`lang\`, \`name\`, \`value\`, \`data_type\`, \`description\`, \`org_id\`) SELECT
'${item.name}', @groupNameGroupId, 'zh', '${item.title}', '${item.value}', 'STRING', '${item.description}', '100000000000000010';
`
  })}
`
}

module.exports = {
  yamlToSQL,
  yamlToReportSQL,
  yamlToConfigSQL,
}