package com.kylexu.chapter1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * 注解 @RestController 等同于 （@Controller 与 @ResponseBody）
 */
@RestController
@SpringBootApplication
public class Chapter1Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter1Application.class, args);
    }

    @GetMapping("/learn1")
    public String learn1() {
        return "Hello Springboot2";
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {
            System.out.println("以下为Springboot默认提供的bean：");
            String[] beanDefinitionNames = context.getBeanDefinitionNames();
            Arrays.sort(beanDefinitionNames);

            Arrays.stream(beanDefinitionNames).forEach(System.out::println);
        };
    }
}
