package com.non.valent.dto;

import com.non.valent.entity.GatewayRoute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author haimiyang
 * @date:2019/12/24 18:09
 * @version:1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GatewayRouteQueryDTO extends BaseDTO<GatewayRoute> {
    private String uri;
}
