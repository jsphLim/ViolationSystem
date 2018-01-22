package com.ly.ssm.contract;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Uint;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class AddorSearchContract extends Contract{

    /**
     *
     * @param contractAddress 合约地址
     * @param web3j　rpc请求
     * @param credentials　钱包地址
     * @param gasPrice　gas价格
     * @param gasLimit　gas限度
     */
    public AddorSearchContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super("", contractAddress, web3j,credentials, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> addMsg(String username, String ID, String violateRecord, BigInteger lowPoint, String AdministratorName) throws IOException {
        Function function = new Function("addMsg",Arrays.<Type>asList(new Utf8String(username),new Utf8String(ID),new Utf8String(violateRecord)
                ,new Uint(lowPoint),new Utf8String(AdministratorName)),Arrays.<TypeReference<?>>asList());
        return executeRemoteCallTransaction(function);
    }

    /**
     * 获取区块链中违章记录数量
     */

    public RemoteCall<Uint>  returnTotal() throws IOException {
        Function function = new Function("returnTotal",Arrays.<Type>asList(),Arrays.<TypeReference<?>>asList(new TypeReference<Uint>() {
        }));
        return executeRemoteCallSingleValueReturn(function);
    }

    /**
     * 获取违章者姓名
     */
    public RemoteCall<Utf8String>  getuserName(BigInteger id) throws IOException {
        Function function = new Function("getuserName",Arrays.<Type>asList(new Uint(id)),Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
        }));
        return executeRemoteCallSingleValueReturn(function);
    }
    /**
     * 获取违章者身份证
     */
    public RemoteCall<Utf8String>  getID(BigInteger id) throws IOException {
        Function function = new Function("getID",Arrays.<Type>asList(new Uint(id)),Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
        }));
        return executeRemoteCallSingleValueReturn(function);
    }
    /**
     * 获取违章者违章记录
     */
    public RemoteCall<Utf8String>  getviolateRecord(BigInteger id) throws IOException {
        Function function = new Function("getviolateRecord",Arrays.<Type>asList(new Uint(id)),Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
        }));
        return executeRemoteCallSingleValueReturn(function);
    }
    /**
     * 获取违章者违章扣分情况
     */
    public RemoteCall<Uint>  getlowPoint(BigInteger id) throws IOException {
        Function function = new Function("getlowPoint",Arrays.<Type>asList(new Uint(id)),Arrays.<TypeReference<?>>asList(new TypeReference<Uint>() {
        }));
        return executeRemoteCallSingleValueReturn(function);
    }
    /**
     * 获取写入此条违章记录的执法人员
     */
    public RemoteCall<Utf8String>  getAdministrator(BigInteger id) throws IOException {
        Function function = new Function("getAdministrator",Arrays.<Type>asList(new Uint(id)),Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {
        }));
        return executeRemoteCallSingleValueReturn(function);
    }
}
