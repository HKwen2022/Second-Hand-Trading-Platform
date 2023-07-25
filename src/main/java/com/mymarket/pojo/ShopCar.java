package com.mymarket.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopCar {
    private Integer id;
    private Integer uid;
    private Integer cid;
    @JsonProperty("number")
    private Integer cNumber;
}
