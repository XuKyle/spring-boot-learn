package com.kylexu.chapter2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/properties")
public class PropertiesController {
    private Logger logger = LoggerFactory.getLogger(PropertiesController.class);

    private final MyProperties properties;
    private final MyProperties2 myProperties2;

    @Autowired
    public PropertiesController(MyProperties properties, MyProperties2 myProperties2) {
        this.properties = properties;
        this.myProperties2 = myProperties2;
    }

    @GetMapping("/prop")
    public MyProperties myProperties() {
        logger.info("####################");
        logger.info(properties.toString());
        logger.info("####################");
        return properties;
    }

    @GetMapping("/prop2")
    public MyProperties2 myProperties2() {
        logger.info("####################");
        logger.info(myProperties2.toString());
        logger.info("####################");
        return myProperties2;
    }
}
