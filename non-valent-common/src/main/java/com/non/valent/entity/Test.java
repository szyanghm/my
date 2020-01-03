package com.non.valent.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author haimiyang
 * @date:2019/12/19 15:47
 * @version:1.0
 */
@Data
@TableName("t_user")
public class Test {
    private String id;
    private String userId;
    private String file;
}
