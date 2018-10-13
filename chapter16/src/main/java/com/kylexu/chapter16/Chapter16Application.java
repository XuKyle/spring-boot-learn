package com.kylexu.chapter16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class Chapter16Application {


//    Timer： JDK自带的java.util.Timer；通过调度java.util.TimerTask的方式 让程序按照某一个频度执行，但不能在指定时间运行。 一般用的较少。
//
//    ScheduledExecutorService： JDK1.5新增的，位于java.util.concurrent包中；是基于线程池设计的定时任务类，每个调度任务都会被分配到线程池中，并发执行，互不影响。
//
//    Spring Task： Spring3.0 以后新增了task，一个轻量级的Quartz，功能够用，用法简单。
//
//    Quartz： 功能最为强大的调度器，可以让程序在指定时间执行，也可以按照某一个频度执行，它还可以动态开关，但是配置起来比较复杂。现如今开源社区中已经很多基于Quartz 实现的分布式定时任务项目（xxl-job、elastic-job）。


    public static void main(String[] args) {
        SpringApplication.run(Chapter16Application.class, args);
    }

    /**
     * 很关键：默认情况下 TaskScheduler 的 poolSize = 1
     *
     * @return 线程池
     */
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(10);
        return scheduler;
    }
}
