package com.mymarket.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commodity {
    private Integer id;
    private String name;
    private String description;
    private Integer publisher;
    private String type;
    private BigDecimal price;
    private Integer stock;
    @JsonProperty("image_url")
    private String imageUrl1;
    @JsonProperty("image_url2")
    private String imageUrl2;
    @JsonProperty("image_url3")
    private String imageUrl3;
    @JsonProperty("image_url4")
    private String imageUrl4;
}
