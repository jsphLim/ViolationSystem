# 基于以太坊的车辆违章记录系统

# 1.开发环境:

(1)Intellij Idea 2017

(2)Geth1.7.3

(3)Ethereum0.9.3

(4)Ubuntu16.04

# 2.准备工作

(1)安装Ethereum钱包 

https://www.ethereum.org/

(2) geth安装 

Ubuntu用户可以选择在线安装的方式，在终端中依次执行以下命令即可：

sudo add-apt-repository -y ppa:ethereum/ethereum

sudo apt-get update

sudo apt-get install ethereum

安装完成后执行 geth help 查看geth的用法。

# 3.初始化以太坊

(1)创建工作目录

(2)在工作目录下配置创世快 genesis.json 

(3)执行geth init genesis.json进行初始化

(4)启动以太坊 geth --rpc --rpcapi personal,db,eth,net,web3 --networkid 666666 console

(5)创建钱包 两种方式 一种是在ethereum图形界面中创建 一种是通过geth执行 personal.newAccount()创建

(6)开始挖矿 miner.start(1) //启用一个线程挖矿 否则是多线程

![Image text](https://raw.githubusercontent.com/jsphLim/ViolationManagement/master/.idea/miner.png)

(7)停止挖矿

# 4.部署合约

(1)合约编写IDE https://remix.ethereum.org/

![Image text](https://raw.githubusercontent.com/jsphLim/ViolationManagement/master/.idea/contract.png)

(2)将编写完的合约在以太坊钱包中发布(Deploy)

![Image text](https://raw.githubusercontent.com/jsphLim/ViolationManagement/master/.idea/deploy.png)

# 5.java开发

使用maven管理 利用web3j库进行开发 

# 6.项目演示

![Image text](https://raw.githubusercontent.com/jsphLim/ViolationManagement/master/.idea/login.png)

登录界面
![Image text](https://raw.githubusercontent.com/jsphLim/ViolationManagement/master/.idea/register.png)

注册界面

![Image text](https://raw.githubusercontent.com/jsphLim/ViolationManagement/master/.idea/add.png)

管理员添加违法记录

![Image text](https://raw.githubusercontent.com/jsphLim/ViolationManagement/master/.idea/search.png)

用户搜索自己的违法记录

![Image text](https://raw.githubusercontent.com/jsphLim/ViolationManagement/master/.idea/searchResult.png)

显示用户的违法记录

本项目中 普通的用户无法进行注册和登录 只有查询功能 只有警署成员与权利增添违法记录 

本项目仅为以太坊的开发学习项目。

