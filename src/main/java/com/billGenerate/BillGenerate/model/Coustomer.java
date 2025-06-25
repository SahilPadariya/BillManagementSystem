package com.billGenerate.BillGenerate.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "coustomer")
public class Coustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String coustomer_name;
    private long mobile_number;
    private String product_name;
    private int product_count;
    private int product_amount;
    private double total_amount;
    private LocalDate localDate;

    public Coustomer() {
    }

    public Coustomer(String coustomer_name, long mobile_number, String product_name, int product_count, int product_amount, double total_amount,LocalDate localDate) {
        this.coustomer_name = coustomer_name;
        this.mobile_number = mobile_number;
        this.product_name = product_name;
        this.product_count = product_count;
        this.product_amount = product_amount;
        this.total_amount = total_amount;
        this.localDate = localDate;
    }

    public int getProduct_amount() {
        return product_amount;
    }

    public void setProduct_amount(int product_amount) {
        this.product_amount = product_amount;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoustomer_name() {
        return coustomer_name;
    }

    public void setCoustomer_name(String coustomer_name) {
        this.coustomer_name = coustomer_name;
    }

    public long getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(long mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_count() {
        return product_count;
    }

    public void setProduct_count(int product_count) {
        this.product_count = product_count;
    }
}
