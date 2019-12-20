package com.non.valent.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.non.valent.entity.Test;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author haimiyang
 * @date:2019/12/19 16:24
 * @version:1.0
 */
@Repository
public interface TestMapper extends BaseMapper<Test>{

    IPage<Test> selectPageVo(Page page, @Param("id") String id);

}
