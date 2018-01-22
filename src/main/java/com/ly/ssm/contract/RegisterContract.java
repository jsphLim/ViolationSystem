package com.ly.ssm.contract;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class RegisterContract extends Contract{
    /**
     *
     * @param contractAddress 合约地址
     * @param web3j　rpc请求
     * @param credentials　钱包地址
     * @param gasPrice　gas价格
     * @param gasLimit　gas限制
     */


    /*自带构造方法*/
    public RegisterContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super("", contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    /**
     * 登录
     */
    public RemoteCall<Bool> login(String username,String password) throws IOException {
        Function function = new Function("login", Arrays.<Type>asList(new Utf8String(username),new Utf8String(password))
        ,Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {
        }));
        return executeRemoteCallSingleValueReturn(function);
    }

    /**
     * 注册检测是否有相同凭证的用户存在
     */
    public RemoteCall<Bool> checkRegister(String adress,String username) throws IOException {
        Function function = new Function("checkRegister",Arrays.<Type>asList(new Address(adress),new Utf8String(username))
        ,Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {
        }));
        return executeRemoteCallSingleValueReturn(function);
    }

    /**
     * 注册
     */

    public RemoteCall<TransactionReceipt> register(String adress,String username,String password) throws IOException {
        Function function = new Function("register",Arrays.<Type>asList(new Address(adress),new Utf8String(username),new Utf8String(password))
        ,Arrays.<TypeReference<?>>asList());
        return executeRemoteCallTransaction(function);
    }

    /**
     *更新密码
     */
    public RemoteCall<TransactionReceipt> updatePassword(String username,String password) throws IOException {
        Function function = new Function("updatePassword",Arrays.<Type>asList(new Utf8String(username),new Utf8String(password))
        ,Arrays.<TypeReference<?>>asList());
        return executeRemoteCallTransaction(function);
    }
}
