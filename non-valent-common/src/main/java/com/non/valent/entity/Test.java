package com.non.valent.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author haimiyang
 * @date:2019/12/19 15:47
 * @version:1.0
 */
@Data
@TableName("t_user")
@AllArgsConstructor
@Accessors(chain = true)
@Document(indexName = "logstash-2020.01.10-000001",type = "_doc", shards = 1, replicas = 0)
public class Test {

    private String id;
    private String userId;
    private String file;
    private String delFag;
}
