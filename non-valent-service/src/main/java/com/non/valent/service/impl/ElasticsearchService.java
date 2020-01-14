package com.non.valent.service.impl;

import com.non.valent.entity.Test;
import com.non.valent.mapper.ElasticMapper;
import com.non.valent.service.IElasticsearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author haimiyang
 * @date:2020/1/10 16:23
 * @version:1.0
 */
@Service
public class ElasticsearchService implements IElasticsearchService {

//    @Autowired
//    private ElasticsearchRestTemplate elasticsearchTemplate;
    @Autowired
    private ElasticMapper elasticRepository;

    private Pageable pageable = PageRequest.of(0,10);
//
//    @Override
//    public void createIndex() {
//        elasticsearchTemplate.createIndex(Test.class);
//    }
//
//    @Override
//    public void deleteIndex(String index) {
//        elasticsearchTemplate.deleteIndex(index);
//    }

    @Override
    public void save(Test docBean) {
        elasticRepository.save(docBean);
    }

    @Override
    public void saveAll(List<Test> list) {
        elasticRepository.saveAll(list);
    }

    @Override
    public List<Test> findAll() {
        List<Test> list = new ArrayList<>();
        Iterator<Test> iterator = elasticRepository.findAll().iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

//    @Override
//    public Page<Test> findByContent(String content) {
//        return elasticRepository.findByContent(content,pageable);
//    }
//
//    @Override
//    public Page<Test> findByFirstCode(String firstCode) {
//        return elasticRepository.findByFirstCode(firstCode,pageable);
//    }
//
//    @Override
//    public Page<Test> findBySecordCode(String secordCode) {
//        return elasticRepository.findBySecordCode(secordCode,pageable);
//    }
//
//    @Override
//    public Page<Test> query(String key) {
//        return elasticRepository.findByContent(key,pageable);
//    }
}
