package com.kyle.springbootmybatistx.controller;

import com.kyle.springbootmybatistx.entity.Account;
import com.kyle.springbootmybatistx.service.AccountService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
@MapperScan("com.kyle.springbootmybatistx.dao")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/transfer", method = RequestMethod.GET)
    public void transfer() {
        accountService.transfer();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountService.findAccountList();
    }
}
