package com.non.valent.service;

import com.non.valent.entity.Test;

import java.util.List;

/**
 * @author haimiyang
 * @date:2020/1/10 16:23
 * @version:1.0
 */
public interface IElasticsearchService {

//    void createIndex();
//
//    void deleteIndex(String index);

    void save(Test test);

    void saveAll(List<Test> list);

    List<Test> findAll();

//    Page<Test> findByContent(String content);
//
//    Page<Test> findByFirstCode(String firstCode);
//
//    Page<Test> findBySecordCode(String secordCode);
//
//    Page<Test> query(String key);
}
