package com.example.lms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class LmsApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ConfigurableApplicationContext context;

    @Test
    void contextLoads() {
        Assertions.assertTrue(context.containsBean("lmsApplication"));
    }

    @Test
    void testJdbc() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from sys_user", Long.class);
        System.out.println(aLong);
        Assertions.assertEquals(2, aLong);
    }
}
