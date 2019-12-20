package com.non.valent;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.non.valent.service.impl.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceApplicationTests {

    @Autowired
    private TestService testService;

	@Test
	public void contextLoads() {
		IPage<com.non.valent.entity.Test> page = testService.selectPageVo(new Page(1,2),"111");
        System.out.println(JSONObject.toJSONString(page));
	}

}
