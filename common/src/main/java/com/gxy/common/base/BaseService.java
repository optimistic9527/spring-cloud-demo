package com.gxy.common.base;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * 单表通用service
 *
 * @author guoxingyong
 * @since 2019/1/3 21:14
 */
public abstract class BaseService<M extends BaseMapper<T>, T>{

    @Autowired
    protected M baseMapper;

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     */
    public T findOne(T entity) {
        return baseMapper.selectOne(entity);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     */
    public List<T> findByCondition(T entity) {
        return baseMapper.select(entity);
    }

    /**
     * 查询全部
     */
    public List<T> findAll() {
        return baseMapper.selectAll();
    }

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     */
    public int count(T entity) {
        return baseMapper.selectCount(entity);
    }

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     */
    public T findById(Object key) {
        return baseMapper.selectByPrimaryKey(key);
    }

    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     */
    public int add(T entity) {
        return baseMapper.insert(entity);
    }

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     */
    public int addSelective(T entity) {
        return baseMapper.insertSelective(entity);
    }


    /**
     * 根据主键更新实体全部字段，null值会被更新
     */
    public int modifyById(T entity) {
        return baseMapper.updateByPrimaryKey(entity);
    }

    /**
     * 根据主键更新属性不为null的值
     */
    public int modifyByIdSelective(T entity) {
        return baseMapper.updateByPrimaryKeySelective(entity);
    }

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     */
    public int remove(T entity) {
        return baseMapper.delete(entity);
    }

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     */
    public int removeById(Object key) {
        return baseMapper.deleteByPrimaryKey(key);
    }
}
