package com.mymarket.pojo;

import java.math.BigDecimal;

public class Commodity {
    private Integer id;
    private String name;
    private String description;
    private Integer publisherId;
    private String type;
    private BigDecimal price;
    private Integer stock;
    public Integer getId(){return id;}
    public String getName(){return name;}
    public String getDescription(){return description;}
    public Integer getPublisherId(){return publisherId;}
    public String getType(){return type;}
    public BigDecimal getPrice(){return price;}
    public Integer getStock(){return stock;}
}
