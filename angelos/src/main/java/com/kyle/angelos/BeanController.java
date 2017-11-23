package com.kyle.angelos;

import com.kyle.angelos.bean.ConfigBean;
import com.kyle.angelos.bean.PropBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({ConfigBean.class, PropBean.class})
public class BeanController {
    @Autowired
    ConfigBean configBean;

    @RequestMapping("/ymlBean")
    public String ymlBean() {
        return configBean.toString();
    }

    @Autowired
    PropBean propBean;

    @RequestMapping("/propBean")
    public String propBean() {
        return propBean.toString();
    }
}
