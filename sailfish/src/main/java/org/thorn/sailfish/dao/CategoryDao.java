package org.thorn.sailfish.dao;

import org.thorn.sailfish.entity.Category;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @Author: yfchenyun
 * @Since: 2013-10-30 13:58:11
 * @Version: 1.0
 */
@Service
public class CategoryDao {

    private static final String NAMESPACE = "CategoryMapper.";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public int save(Category category) {
        return sqlSessionTemplate.insert(NAMESPACE + "insert", category);
    }

    public int modify(Category category) {
        return sqlSessionTemplate.insert(NAMESPACE + "update", category);
    }

    public int delete(List<String> ids) {
        return sqlSessionTemplate.delete(NAMESPACE + "delete", ids);
    }

    public long count(Map<String, Object> filter) {
        return (Long) sqlSessionTemplate.selectOne(NAMESPACE + "count", filter);
    }

    public List<Category> query(Map<String, Object> filter) {
        return (List<Category>) sqlSessionTemplate.selectList(NAMESPACE + "select", filter);
    }

}