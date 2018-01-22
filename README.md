# 基于以太坊的车辆违章记录系统

1.开发环境:
(1)Intellij Idea 2017
(2)Geth1.7.3
(3)Ethereum0.9.3
(4)Ubuntu16.04

2.准备工作
(1)安装Ethereum钱包  https://www.ethereum.org/

(2) geth安装 

Ubuntu用户可以选择在线安装的方式，在终端中依次执行以下命令即可：

sudo add-apt-repository -y ppa:ethereum/ethereum

sudo apt-get update

sudo apt-get install ethereum

安装完成后执行 geth help 查看geth的用法。

3.初始化以太坊

(1)创建工作目录

(2)在工作目录下配置创世快 genesis.json 

(3)执行geth init genesis.json进行初始化

(4)启动以太坊 geth --rpc --rpcapi personal,db,eth,net,web3 --networkid 666666 console

(5)创建钱包 两种方式 一种是在ethereum图形界面中创建 一种是通过geth执行 personal.newAccount()创建

(6)开始挖矿 miner.start(1) //启用一个线程挖矿 否则是多线程

(7)停止挖矿

4.部署合约

(1)合约编写IDE https://remix.ethereum.org/

(2)将编写完的合约在以太坊钱包中发布(Deploy)

5.java开发

使用maven管理 利用web3j库进行开发 
