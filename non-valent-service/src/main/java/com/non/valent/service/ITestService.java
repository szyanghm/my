package com.non.valent.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.non.valent.entity.Test;
import org.apache.ibatis.annotations.Param;

/**
 * @author haimiyang
 * @date:2019/12/19 17:11
 * @version:1.0
 */
public interface ITestService {
    IPage<Test> selectPageVo(Page page, String id);
}
