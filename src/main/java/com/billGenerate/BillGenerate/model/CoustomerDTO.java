package com.billGenerate.BillGenerate.model;

public class CoustomerDTO {
    private String coustomer_name;
    private long mobile_number;
    private String product_name;
    private int product_count;

    public CoustomerDTO() {
    }

    public CoustomerDTO(String coustomer_name, long mobile_number, String product_name, int product_count) {
        this.coustomer_name = coustomer_name;
        this.mobile_number = mobile_number;
        this.product_name = product_name;
        this.product_count = product_count;
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
