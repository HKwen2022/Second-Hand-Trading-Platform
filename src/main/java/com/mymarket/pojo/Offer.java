package com.mymarket.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
    @JsonProperty("date")
    public LocalDate orderDate;
    @JsonProperty("address")
    public String deliveryAddress;
    @JsonProperty("address2")
    public String shippingAddress;
    @JsonProperty("date2")
    public LocalDate shippingDate;
    @JsonProperty("date3")
    public LocalDate deliverDate;
}
