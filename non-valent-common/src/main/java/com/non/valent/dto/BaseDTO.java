package com.non.valent.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;

/**
 * @author haimiyang
 * @date:2019/12/24 18:20
 * @version:1.0
 */
@Data
public class BaseDTO<T> {

    public QueryWrapper<T> build() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        return queryWrapper;
    }
}
