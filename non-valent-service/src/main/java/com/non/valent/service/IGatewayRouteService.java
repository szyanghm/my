package com.non.valent.service;

import com.non.valent.dto.GatewayRouteQueryDTO;
import com.non.valent.entity.GatewayRoute;
import com.non.valent.vo.GatewayRouteVO;

import java.util.List;

/**
 * @author haimiyang
 * @date:2019/12/24 16:58
 * @version:1.0
 */
public interface IGatewayRouteService {
    /**
     * 获取网关路由
     *
     * @param id
     * @return
     */
    GatewayRoute get(String id);

    /**
     * 新增网关路由
     *
     * @param gatewayRoute
     * @return
     */
    boolean add(GatewayRoute gatewayRoute);

    /**
     * 查询网关路由
     *
     * @return
     */
    List<GatewayRouteVO> query(GatewayRouteQueryDTO dto);

    /**
     * 更新网关路由信息
     *
     * @param gatewayRoute
     */
    boolean update(GatewayRoute gatewayRoute);

    /**
     * 根据id删除网关路由
     *
     * @param id
     */
    boolean delete(String id);

    /**
     * 重新加载网关路由配置到redis
     *
     * @return 成功返回true
     */
    boolean overload();
}
