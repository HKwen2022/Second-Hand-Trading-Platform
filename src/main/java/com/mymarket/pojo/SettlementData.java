package com.mymarket.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SettlementData {
    @JsonProperty("list")
    List<Integer> list;
    @JsonProperty("address")
    String deliveryAddress;
}
