package com.hongmai.conference.mapper;

import com.hongmai.conference.model.domain.CpBaseResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.Set;

/**
 * @Entity com.hongmai.conference.model.domain.CpBaseResource
 */
public interface CpBaseResourcesMapper extends BaseMapper<CpBaseResource> {

    /**
     * 批量新增权限资源
     * @param resources 资源对象集合
     * @return 受影响的行数
     */
    int insertResources(@Param("resources") Collection<CpBaseResource> resources);
}




