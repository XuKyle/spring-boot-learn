package com.kylexu.springbootlocaldate.controller;

import com.kylexu.springbootlocaldate.pojo.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @GetMapping
    public Order query() {
        Order order = new Order();
        order.setPayTime(LocalDateTime.now());
        return order;
    }
}
