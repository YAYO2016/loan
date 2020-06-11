package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.CfgDictValue;
import com.framework.mybatis.mysql.pojo.CfgDictValueExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CfgDictValueMapper {
    int countByExample(CfgDictValueExample example);

    int deleteByExample(CfgDictValueExample example);

    int insert(CfgDictValue record);

    int insertSelective(CfgDictValue record);

    List<CfgDictValue> selectByExample(CfgDictValueExample example);

    int updateByExampleSelective(@Param("record") CfgDictValue record, @Param("example") CfgDictValueExample example);

    int updateByExample(@Param("record") CfgDictValue record, @Param("example") CfgDictValueExample example);

    List<Map<String, Object>> queryList(@Param("map")Map<String, Object> map);

}