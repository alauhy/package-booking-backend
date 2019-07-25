package com.oocl.packagebooking.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "package")
public class Package {
    @Id
    private String orderId;
    @NotNull
    private String customerName;
    @NotNull
    private String phone;
    @NotNull
    private int status;
    private long bookTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getBookTime() {
        return bookTime;
    }

    public void setBookTime(long bookTime) {
        this.bookTime = bookTime;
    }
}
