package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.DictAgency;
import com.framework.mybatis.mysql.pojo.DictAgencyExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DictAgencyMapper {
    int countByExample(DictAgencyExample example);

    int deleteByExample(DictAgencyExample example);

    int insert(DictAgency record);

    int insertSelective(DictAgency record);

    List<DictAgency> selectByExample(DictAgencyExample example);

    int updateByExampleSelective(@Param("record") DictAgency record, @Param("example") DictAgencyExample example);

    int updateByExample(@Param("record") DictAgency record, @Param("example") DictAgencyExample example);
    
    List<Map<String, Object>> queryList(@Param("map")Map<String, Object> map);
}