package com.yzy.demo.feature;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author young
 * @date 2019/7/31 15:39
 */
@Data
@AllArgsConstructor
public class ReqInfo {
    private String id ;
    private Boolean flag;
    private String name;
}
