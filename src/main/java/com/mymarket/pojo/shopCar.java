package com.mymarket.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopCar {
    private Integer uid;
    private Integer cid;
    private String name;
    private String cImageUrl;
    private String type;
    private Integer number;
}
