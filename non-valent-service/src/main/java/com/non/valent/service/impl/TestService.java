package com.non.valent.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.non.valent.entity.Test;
import com.non.valent.mapper.TestMapper;
import com.non.valent.service.ITestService;
import org.springframework.stereotype.Service;

/**
 * @author haimiyang
 * @date:2019/12/19 17:12
 * @version:1.0
 */
@Service
public class TestService extends ServiceImpl<TestMapper,Test> implements ITestService {

    @Override
    public IPage<Test> selectPageVo(Page page, String id) {
        return  baseMapper.selectPageVo(page,id);
    }
}
