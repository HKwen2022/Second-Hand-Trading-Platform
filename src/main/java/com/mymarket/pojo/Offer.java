package com.mymarket.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Offer {
    private Integer id;
    private Integer uid;
    private Integer cid;
    private Integer number;
    private BigDecimal totalPrice;
    private Date orderDate;
    private String DeliveringAddress;
    private String shippingAddress;
    private Date deliverDate;
    public Integer getId(){
        return id;
    }
    public Integer getUid(){
        return uid;
    }
    public Integer getCid(){
        return cid;
    }
    public Integer getNumber(){
        return number;
    }
    public Date getDeliverDate() {
        return deliverDate;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    public String getDeliveringAddress() {
        return DeliveringAddress;
    }
    public String getShippingAddress() {
        return shippingAddress;
    }
}
