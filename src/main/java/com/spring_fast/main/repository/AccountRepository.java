package com.spring_fast.main.repository;

import com.spring_fast.main.model.Account;
import com.spring_fast.main.repository.mapper.AccountRowMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepository {

    private final JdbcTemplate jdbcTemplate;

    public AccountRepository(
            @Qualifier("mysqlJdbcTemplate") JdbcTemplate jdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findAccountById(long id) {
        String sqlQuery = "select * from account where id = ?;";

        return jdbcTemplate.queryForObject(sqlQuery, new AccountRowMapper(), id);
    }

    public void changeAccount(long id, BigDecimal amount) {
        String sqlQuery = "update account set amount = ? where id = ?;";

        jdbcTemplate.update(sqlQuery, amount, id);
    }

    public List<Account> getAllAccounts() {
        String sqlQuery = "select * from account;";

        return jdbcTemplate.query(sqlQuery, new AccountRowMapper());
    }
}
