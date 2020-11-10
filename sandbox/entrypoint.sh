#!/bin/bash

# 设置为淘宝镜像（加速npm install）
npm config set registry http://registry.npm.taobao.org

# 初始化crudless工具集
cd /var/crudless
if [ ! -d node_modules ];then
    npm i -g
fi

# 初始化issue服务API
cd /issue
if [ ! -d node_modules ];then
    npm install
fi

# 启动issue服务API
node App.js