package com.example.lms.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class CustomDataSourceConfig {
    /**
     * @see org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
     * @ConditionalOnClass({ DataSource.class, EmbeddedDatabaseType.class })
     * @return DataSource
     */
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();

//        druidDataSource.setUrl("...");
//        druidDataSource.setUsername("...");
//        druidDataSource.setPassword("...");
//        druidDataSource.setDriverClassName("...");

        return druidDataSource;
    }
}
