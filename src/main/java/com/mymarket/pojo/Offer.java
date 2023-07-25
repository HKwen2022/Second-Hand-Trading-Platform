package com.mymarket.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

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
    private LocalDate orderDate;
    private String deliveringAddress;
    private String shippingAddress;
    private LocalDate deliverDate;
}
