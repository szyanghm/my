package com.non.valent.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haimiyang
 * @date:2020/1/15 16:27
 * @version:1.0
 */
@Data
public class TUser implements Serializable {
    private static final long serialVersionUID = 3497935890426858541L;

    private String userName;
    private String password;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked= true;
    private boolean credentialsNonExpired= true;
    private boolean enabled= true;
}
