package com.kylexu.chapter6;

import com.kylexu.chapter6.entity.User;
import com.kylexu.chapter6.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter6ApplicationTests {

    private Logger logger = LoggerFactory.getLogger(Chapter6ApplicationTests.class);

    @Autowired
    UserRepository userRepository;

    @Test
    public void contextLoads() {
        final User user = userRepository.save(new User("u1", "p1"));
        logger.info("[添加成功] - [{}]", user);

        final List<User> u1 = userRepository.findAllByUsername("u1");
        logger.info("[条件查询] - [{}]", u1);

        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("username")));
        final Page<User> users = userRepository.findAll(pageable);
        logger.info("[分页+排序+查询所有] - [{}]", users.getContent());

        userRepository.findById(users.getContent().get(0).getId()).ifPresent(user1 -> logger.info("[主键查询] - [{}]", user1));
        final User edit = userRepository.save(new User(user.getId(), "修改后的ui", "修改后的p1"));
        logger.info("[修改成功] - [{}]", edit);

        userRepository.deleteById(user.getId());
        logger.info("[删除主键为 {} 成功] - [{}]", user.getId());
    }

}
