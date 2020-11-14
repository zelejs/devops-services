#!/bin/bash

# 初始化依赖
cd /db-service
pip install -i https://pypi.tuna.tsinghua.edu.cn/simple -r requirements.txt

python --version
pip --version
pip list


# 配置flask 配置为热部署环境
# export FLASK_APP=db-service
# export FLASK_ENV=development

# 启动db-service
flask run --host=0.0.0.0 --port=8080