package com.mymarket.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopCar {
    private Integer id;
    private Integer uid;
    private Integer cid;
    @JsonProperty("number")
    private Integer cNumber;
    private BigDecimal price;
    private String name;
    private String image_url;
}
