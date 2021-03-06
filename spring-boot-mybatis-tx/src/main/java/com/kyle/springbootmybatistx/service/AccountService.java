package com.kyle.springbootmybatistx.service;

import com.kyle.springbootmybatistx.dao.AccountMapper;
import com.kyle.springbootmybatistx.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountMapper accountMapper;

    @Transactional
    public void transfer() throws RuntimeException {
        accountMapper.update(90, 1);//用户1减10块 用户2加10块
        int i = 1 / 0;
        accountMapper.update(110, 2);
    }

    public List<Account> findAccountList() {
        return accountMapper.findAccountList();
    }
}
