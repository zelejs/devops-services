
/**
 * 处理列表的 action 项
 * @param {object} action 
 * @param {string} pageName 
 * @param {boolean} outside 是否自动将 outside 设置为 false. 顶部的 action 应该传入 undefined
 * @param {object} setting 含有用于生成 modal 的数据
 */
function tableAction(action, pageName, outside, setting) {
  const { title, type, options, expect, modal = {}, ...rest } = action;
  const rst = {
    title,
    type,
    options: rest,
    expect,
  };
  if (type) {
    rst.type = type;
    if (['add', 'edit', 'view'].includes(type)) {
      rst.options.path = `${pageName}/${pageName}-${type}`;
      rst.type = 'path';
    }
  }

  if (rst.options && rst.options.api) {
    rst.options.API = rst.options.api;
    delete rst.options.api;
  }

  if (outside) {
    rst.options.outside = rst.options.outside || false;
  }

  if (type === 'modal') {
    const { fields, api } = modal;
    rst.options.items = [
      {
        component: 'Form',
        config: {
          layout: 'Grid',
          layoutConfig: {
            value: Array(setting.columns).fill(~~(24 / setting.columns))
          },
          API: api || (
            outside === undefined ? {
              createAPI: setting.createAPI,
            } : {
                getAPI: setting.getAPI.replace('[id]', '(id)'),
                updateAPI: setting.updateAPI.replace('[id]', '(id)'),
              }),
          fields: fields || (
            outside === undefined ? setting.createFields
              : setting.updateFields
          )
        }
      }
    ]
  }

  return rst
}

module.exports = tableAction;