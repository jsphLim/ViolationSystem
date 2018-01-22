package com.ly.ssm.service;

import com.ly.ssm.contract.RegisterContract;
import com.ly.ssm.utils.Consts;
import com.ly.ssm.utils.util;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

import java.io.IOException;
import java.math.BigInteger;

public class UserService {
    private RegisterContract contract;

    public UserService() throws IOException, CipherException {
        Credentials credentials = WalletUtils.loadCredentials(Consts.PASSWORD,Consts.PATH);
        contract = util.getRegisterContract(credentials,Consts.REGISTER_ADDR);
    }

    public boolean login(String username, String password) throws Exception {
        return contract.login(username,password).send().getValue();

    }

    public boolean checkRegister(String adress,String username) throws Exception {
        return contract.checkRegister(adress,username).send().getValue();
    }

    public boolean Register(String adress, String username, String password) throws Exception {
        if(!checkRegister(adress,username)){
            contract.register(adress,username,password).send();
            return true;
        }
        return false;
    }

    public void UpdatePassword(String username, String newPass) throws Exception {
        contract.updatePassword(username,newPass).send();
    }

}
