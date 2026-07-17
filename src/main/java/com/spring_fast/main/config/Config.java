package com.spring_fast.main.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import javax.sql.DataSource;

@Configuration
@EnableFeignClients(basePackages = "com.spring_fast.main.proxy")
public class Config {

    @Value("${spring.datasource.mysql.url}")
    private String mysqlUrl;

    @Value("${spring.datasource.h2.url}")
    private String h2Url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DataSource mysqlDataSource() {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setJdbcUrl(mysqlUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setConnectionTimeout(1000);

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager msqlTransactionManager(
            @Qualifier("mysqlDataSource") DataSource mysqlDataSource
    ) {
        return new DataSourceTransactionManager(mysqlDataSource);
    }

    @Bean
    public DataSource h2DataSource() {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setJdbcUrl(h2Url);
        dataSource.setConnectionTimeout(1000);

        return dataSource;
    }

    @Bean
    public JdbcTemplate mysqlJdbcTemplate(
            @Qualifier("mysqlDataSource") DataSource mysqlDataSource
    ) {
        return new JdbcTemplate(mysqlDataSource);
    }

    @Bean
    public JdbcTemplate h2JdbcTemplate(
            @Qualifier("h2DataSource")DataSource h2DataSource
    ) {
        return new JdbcTemplate(h2DataSource);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}
