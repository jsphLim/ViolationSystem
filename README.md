# 基于以太坊的车辆违章记录系统


# 写在前面

如果你对以太坊的部署不了解的话 可以到李赫先生的博客先进行学习

http://blog.csdn.net/sportshark/article/details/52351415


部署中需要注意一些问题 首先是config.properties文件 其中需要将钱包地址更改为你自己的钱包地址 否则会报FileNotFound的错误

其次 合约的部署需要在自己的电脑上进行部署(注意先启动挖矿才能部署) 不能直接用我的合约地址 也不能直接在https://remix.ethereum.org/  上面部署

否则会出现空指针的错误 可以先在MainTest文件中进行调试  项目运行全程都必须进行挖矿来达成共识 

项目中的注册页面里面的凭证其实就是你的钱包地址 是一串十六进制的字符串 可以在你的ethereum钱包客户端中copy Address来获得 较好的方式是写成文件上传 直接上传钱包文件 但由于笔者开发时间较紧 没有实现这个功能

 笔者写这个项目的时间只有两天 所以一些细节并没有很好的完善 注册和写入违法记录进入区块链的等待时间可以会久一些 这是因为区块链自身的局限性 请耐心等

待 项目功能较为简单 主要的开发框架是通过继承web3j的Contract 然后再使用java调用合约中的函数 项目中所有调用方法都写成同步调用 没有使用异步 使用异步响
应速度会快一些 日后会再做更新 

笔者现年大二在读 项目经验不多 代码有些地方可能写得不是很好 请见谅 有什么问题可以通过我github主界面的邮箱进行联系 希望本项目对大家有所帮助~

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

![Image text](https://raw.githubusercontent.com/jsphLim/ViolationManagement/master/.idea/register.png)


![Image text](https://raw.githubusercontent.com/jsphLim/ViolationManagement/master/.idea/add.png)


![Image text](https://raw.githubusercontent.com/jsphLim/ViolationManagement/master/.idea/search.png)


![Image text](https://raw.githubusercontent.com/jsphLim/ViolationManagement/master/.idea/searchResult.png)


本项目中 普通的用户无法进行注册和登录 只有查询功能 只有警察有权添加车辆违章记录

本项目仅为以太坊的开发学习项目。

