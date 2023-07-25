package com.mymarket.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offer {
    private Integer id;
    private Integer uid;
    private Integer cid;
    private BigDecimal price;
    private Integer number;
    //private BigDecimal totalPrice;
    public LocalDate orderDate;
    public String deliveryAddress;
    public String shippingAddress;
    public LocalDate deliverDate;
}
