const fs = require('fs-extra');
const path = require('path');

/**
 * 把 swagger 里面天书一样的格式，格式化为 人类看得懂的格式
 * @returns Promise
 */
module.exports = function format(swaggerFilePath) {
  const swaggerFiletPath = path.join(swaggerFilePath, 'swagger.json');

  return fs.readJSON(swaggerFiletPath).then((jsonData) => {
    const rstData = {};
    const APIObject = jsonData.paths;
    Object.keys(APIObject).forEach(API => {
      const APIItem = APIObject[API];
      Object.keys(APIItem).forEach(method => {
        const current = APIItem[method];
        rstData[API] = rstData[API] || {};
        rstData[API].API = API;
        rstData[API][method] = {
          fields: [],
          ref: current['responses']['200'] && current['responses']['200']['schema']['$ref'],
          summary: `${(current.tags || []).join('')} ${current.summary}`,
          parameters: current.parameters,
        }
      })
    });
    Object.keys(rstData).forEach(API => {
      const current = rstData[API];
      checkRef(current, jsonData);
    });
    return fs.outputFile(path.join(swaggerFilePath, 'format.json'), JSON.stringify(rstData, null, 2), {
      encoding: 'utf-8'
    });
  });
}

/**
 * 找到当前 ref
 *
 * @param {*} current
 * @param {*} jsonData
 * @returns
 */
function checkRef(current, jsonData) {
  if (typeof current === 'string') {
    // children ref
    return formatRef(current, jsonData);
  }
  const methodList = ['get', 'post', 'put', 'delete'];
  methodList.forEach(method => {
    if (current[method]) {
      if (method === 'get') {
        current[method].fields = formatRef(current[method].ref, jsonData, false);
      } else {
        current[method].parameters && current[method].parameters.forEach(item => {
          if (item.schema) {
            if (item.schema['$ref']) {
              current[method].fields = formatRef(item.schema['$ref'], jsonData);
            } else {
              console.log(`非标准的 API：${method} ${current.API} 对象 parameters.schema 之下没有key: $ref`);
            }
          } else {
            current[method].fields.push(item);
          }
        });
      }
    }
  });
}

function formatRef(ref, jsonData, type) {
  if (typeof ref === 'string') {
    const refArray = ref.replace('#/', '').split('/');

    let refObj = jsonData;
    refArray.forEach(key => {
      refObj = refObj[key];
    });
    const fields = [];
    Object.keys(refObj.properties).forEach(field => {
      fields.push(
        formatField(field, refObj.properties[field], jsonData, type)
      );
    });
    return fields;
  }
  return [{ field: 'demo', label: '非标准的格式' }]
}

/**
 * 从 swagger 的 definitions properties 里面返回标准的 field 配置项
 *
 * @param {*} field 当前字段
 * @param {*} options 当前字段的其它属性
 * @param {*} jsonData 原始 swagger JSON 对象
 * @param {Boolean} type 是否返回 type
 * @returns
 */
function formatField(field, options, jsonData, type = true) {
  if (options['$ref']) {
    return checkRef(options['$ref'], jsonData);
  }
  if (type) {
    return {
      field,
      label: field,
      type: formatType(options),
    }
  }
  return {
    field,
    label: field,
  }
}

function formatType(options) {
  const typeMap = {
    'string': 'input',
    'number': 'number',
    'integer': 'number',
    'int32': 'number',
    'int64': 'number',
    'date-time': 'date',
    'object': 'plain',
  };
  const type = options.format || options.type;
  return typeMap[type] || `is_undefined_${type}`;
}