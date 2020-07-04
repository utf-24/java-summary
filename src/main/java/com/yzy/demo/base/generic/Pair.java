package com.yzy.demo.base.generic;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yangzyh
 * @date 2020/7/4 10:27
 */
@Data
@AllArgsConstructor
public class Pair<T> {
    private T first;
    private T second;
}
