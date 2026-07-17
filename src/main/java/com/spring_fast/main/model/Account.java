package com.spring_fast.main.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {

    private long id;
    private String name;
    private BigDecimal amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", name=" + name + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Account account = (Account) obj;
        return id == account.id &&
                name.equals(account.name) &&
                amount.equals(account.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, amount);
    }
}
