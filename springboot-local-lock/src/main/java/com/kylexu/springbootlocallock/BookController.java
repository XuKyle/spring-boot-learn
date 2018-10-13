package com.kylexu.springbootlocallock;

import com.kylexu.springbootlocallock.annotation.LocalLock;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @LocalLock(key = "book:arg[0]")
    @GetMapping
    public String query(@RequestParam String token) {
        return "sucess = " + token;
    }
}
