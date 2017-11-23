package com.kyle.springbootmybatistx.dao;

import com.kyle.springbootmybatistx.entity.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {
    int update(@Param("money") double money, @Param("id") int id);

    List<Account> findAccountList();
}
