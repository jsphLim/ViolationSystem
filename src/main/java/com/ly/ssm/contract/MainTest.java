package com.ly.ssm.contract;

import com.ly.ssm.utils.Consts;
import org.web3j.abi.datatypes.Bool;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

public class MainTest {
    public static void main(String[] args) throws Exception {
        Credentials credentials = WalletUtils.loadCredentials(Consts.PASSWORD,Consts.PATH);

        System.out.println(Consts.PASSWORD+Consts.PATH);

        Web3j web3j = Web3j.build(new HttpService());

        RegisterContract registerContract = new RegisterContract(Consts.REGISTER_ADDR,web3j,credentials,Consts.GAS_PRICE,Consts.GAS_LIMIT);

        RemoteCall<Bool> login = registerContract.login("linyue","123456");
        System.out.println(login.send().getValue());

        AddorSearchContract addorSearchContract = new AddorSearchContract(Consts.ADDORSEARCH_ADDR,web3j,credentials,Consts.GAS_PRICE,Consts.GAS_LIMIT);

        BigInteger total = addorSearchContract.returnTotal().send().getValue();
        int n = new Integer(total.toString());
        for(int i=0;i<n;i++){
            System.out.println(addorSearchContract.getuserName(BigInteger.valueOf(i)).send().getValue());
            System.out.println(addorSearchContract.getID(BigInteger.valueOf(i)).send().getValue());
        }


    }
}
