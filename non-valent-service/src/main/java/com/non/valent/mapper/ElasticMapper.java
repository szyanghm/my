package com.non.valent.mapper;

import com.non.valent.entity.Test;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author haimiyang
 * @date:2020/1/10 16:13
 * @version:1.0
 */
public interface ElasticMapper extends ElasticsearchRepository<Test, Long> {

    //默认的注释
    //@Query("{\"bool\" : {\"must\" : {\"field\" : {\"content\" : \"?\"}}}}")
//    Page<Test> findByContent(String content, Pageable pageable);
//
//    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"firstCode.keyword\" : \"?\"}}}}")
//    Page<Test> findByFirstCode(String firstCode, Pageable pageable);
//
//    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"secordCode.keyword\" : \"?\"}}}}")
//    Page<Test> findBySecordCode(String secordCode, Pageable pageable);
}
