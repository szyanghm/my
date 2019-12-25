package com.non.valent.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author haimiyang
 * @date:2019/12/24 17:29
 * @version:1.0
 */
@Data
@NoArgsConstructor
public class BaseVO<T> implements Serializable {
    private String id;
}
