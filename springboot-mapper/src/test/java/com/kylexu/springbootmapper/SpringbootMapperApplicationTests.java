package com.kylexu.springbootmapper;

import com.kylexu.springbootmapper.mapper.CountryMapper;
import com.kylexu.springbootmapper.model.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMapperApplicationTests {

    private Logger logger = LoggerFactory.getLogger(SpringbootMapperApplicationTests.class);

    @Autowired
    private CountryMapper countryMapper;

   /* @Test
    public void testInsert() {
        Country country = new Country();
        country.setCountryCode("001");
        country.setCountryName("China");
        countryMapper.insert(country);
        logger.info("Insert Success！");
    }

    @Test
    public void testSelect() {
        Country country = new Country();
        country.setId(10011);
        countryMapper.select(country);
        logger.info("country:{}", country);
    }

    @Test
    public void testUpdate() {
        Country country = new Country();
        country.setId(10011);
        country.setCountryCode("100");
        countryMapper.updateByPrimaryKeySelective(country);
        logger.info("update success!");
    }*/

    @Test
    public void testSelectAll() {
        List<Country> countries = countryMapper.selectAll();
        countries.forEach(country -> logger.info("country:{}", country));
    }

    @Test
    public void contextLoads() {

    }

}
