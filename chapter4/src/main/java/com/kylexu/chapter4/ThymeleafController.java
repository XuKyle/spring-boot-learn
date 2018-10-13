package com.kylexu.chapter4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class ThymeleafController {
    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");

        view.addObject("title", "thymeleaf 页面");
        view.addObject("desc", "Welcome to Thymeleaf!");

        Author author = new Author("kyle.xu", "kyle.xu@gmail.com", 18);
        view.addObject("author", author);

        return view;
    }

    @GetMapping("/index1")
    public String index1(HttpServletRequest request) {
        // TODO 与上面的写法不同，但是结果一致。
        // 设置属性
        request.setAttribute("title", "thymeleaf 页面");
        request.setAttribute("desc", "Welcome to Thymeleaf!");

        Author author = new Author("kyle.xu@thymeleaf", "kyle.xu@gmail.com", 18);
        request.setAttribute("author", author);

        request.setAttribute("author", author);
        // 返回的 index 默认映射到 src/main/resources/templates/xxxx.html
        return "index";
    }
}
