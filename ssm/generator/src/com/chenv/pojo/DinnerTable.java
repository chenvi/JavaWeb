package com.chenv.pojo;

import java.util.Date;

public class DinnerTable {
    private Integer id;

    private String tableName;

    private Integer tableStatus;

    private Date orderDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public Integer getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Integer tableStatus) {
        this.tableStatus = tableStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}