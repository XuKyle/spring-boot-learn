package com.kylexu.chapter19;

import com.kylexu.chapter19.annotation.DateTime;
import com.kylexu.chapter19.group.Groups;
import com.kylexu.chapter19.pojo.Book;
import com.kylexu.chapter19.pojo.BookGroup;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@Validated
@RestController
public class ValidateController {

    @GetMapping("/test2")
    public String test2(@NotBlank(message = "name 不能为空") @Length(min = 2, max = 10, message = "name 长度必须在 {min} - {max} 之间") String name) {
        return "success";
    }

    @GetMapping("/test3")
    public String test3(@Validated Book book) {
        return "success";
    }

    /*验证自定义注解*/
    @GetMapping("/test")
    public String test(@DateTime(message = "您输入的格式错误，正确的格式为：{format}", format = "yyyy-MM-dd HH:mm") String date) {
        return "success";
    }

    /*分组验证*/
    @GetMapping("/insert")
    public String insert(@Validated(value = Groups.Default.class) BookGroup book) {
        return "insert";
    }

    @GetMapping("/update")
    public String update(@Validated(value = {Groups.Default.class, Groups.Update.class}) BookGroup book) {
        return "update";
    }
}
