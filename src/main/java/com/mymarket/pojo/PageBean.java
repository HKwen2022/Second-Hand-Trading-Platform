package com.mymarket.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageBean {
    Long count;
    List list;
}
