#!/bin/bash

BASE_URL="http://localhost:8080/api/test"

echo "开始测试区块链系统..."

# 测试系统是否运行
echo "1. 测试系统状态..."
curl -s $BASE_URL/ping
echo -e "\n"

# 创建测试交易
echo "2. 创建测试交易..."
curl -s -X POST $BASE_URL/create-transaction
echo -e "\n"

# 等待2秒
sleep 2

# 触发挖矿
echo "3. 开始挖矿..."
curl -s -X POST $BASE_URL/mine
echo -e "\n"

# 等待2秒
sleep 2

# 查看状态
echo "4. 查看区块链状态..."
curl -s $BASE_URL/status
echo -e "\n"

echo "测试完成！" 