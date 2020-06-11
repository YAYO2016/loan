package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.CfgDict;
import com.framework.mybatis.mysql.pojo.CfgDictExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CfgDictMapper {
    int countByExample(CfgDictExample example);

    int deleteByExample(CfgDictExample example);

    int insert(CfgDict record);

    int insertSelective(CfgDict record);

    List<CfgDict> selectByExample(CfgDictExample example);

    int updateByExampleSelective(@Param("record") CfgDict record, @Param("example") CfgDictExample example);

    int updateByExample(@Param("record") CfgDict record, @Param("example") CfgDictExample example);
    
    List<Map<String, Object>> queryList(@Param("map")Map<String, Object> map);
}