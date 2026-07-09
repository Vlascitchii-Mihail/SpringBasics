package com.spring_fast.main.repository;

import com.spring_fast.main.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;

    public PurchaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void storePurchase(Purchase purchase) {
        String sqlQuery = "insert into purchase (product, price) values(?, ?);";

        jdbcTemplate.update(sqlQuery, purchase.getProduct(), purchase.getPrice());
    }

    public List<Purchase> getAllPurchase() {
        String sql = "select * from purchase";

        RowMapper<Purchase> purchaseRowMapper = (ResultSet resultSet, int rowNumber) -> {
            Purchase rowObject = new Purchase();
            rowObject.setId(resultSet.getInt("id"));
            rowObject.setProduct(resultSet.getString("product"));
            rowObject.setPrice(resultSet.getBigDecimal("price"));

            return rowObject;
        };

        return jdbcTemplate.query(sql, purchaseRowMapper);
    }
}
