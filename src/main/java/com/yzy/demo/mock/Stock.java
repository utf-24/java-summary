package com.yzy.demo.mock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author young
 * @date 2019/6/13 16:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    private String stockId;
    private String name;
    private int quantity;

}