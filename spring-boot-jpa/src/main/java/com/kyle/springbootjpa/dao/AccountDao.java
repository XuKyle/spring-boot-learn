package com.kyle.springbootjpa.dao;

import com.kyle.springbootjpa.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Integer> {
}
