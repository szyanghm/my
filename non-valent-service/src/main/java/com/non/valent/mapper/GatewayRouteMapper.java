package com.non.valent.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.non.valent.entity.GatewayRoute;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author haimiyang
 * @date:2019/12/24 18:27
 * @version:1.0
 */
@Mapper
@Repository
public interface GatewayRouteMapper extends BaseMapper<GatewayRoute> {
}
