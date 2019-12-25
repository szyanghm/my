package com.non.valent.entity;

import lombok.*;

/**
 * @author haimiyang
 * @date:2019/12/24 17:23
 * @version:1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GatewayRoute extends BaseEntity{
    private String uri;
    private String routeId;
    private String predicates;
    private String filters;
    private String description;
    private Integer orders = 0;
    private String status = "Y";
}
