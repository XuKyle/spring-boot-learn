package com.kylexu.springbootmapper.config;

import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;

public class MybatisGenerator {

    @Test
    public void test() throws Exception {
        System.out.println(System.getProperty("user.dir"));
        String config = System.getProperty("user.dir") + File.separator + "src/main/resources/generatorConfig.xml";
        System.out.println("config = " + config);

        ArrayList<String> warnings = new ArrayList<String>();

        ConfigurationParser parser = new ConfigurationParser(warnings);
        Configuration configuration = parser.parseConfiguration(new File(config));
        DefaultShellCallback callback = new DefaultShellCallback(true);

        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
