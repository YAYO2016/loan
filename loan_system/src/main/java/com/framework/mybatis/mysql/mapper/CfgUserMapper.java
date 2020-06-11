package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.CfgUser;
import com.framework.mybatis.mysql.pojo.CfgUserExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CfgUserMapper {
    int countByExample(CfgUserExample example);

    int deleteByExample(CfgUserExample example);

    int insert(CfgUser record);

    int insertSelective(CfgUser record);

    List<CfgUser> selectByExample(CfgUserExample example);

    int updateByExampleSelective(@Param("record") CfgUser record, @Param("example") CfgUserExample example);

    int updateByExample(@Param("record") CfgUser record, @Param("example") CfgUserExample example);

    List<Map<String, Object>>  queryUserList(@Param("map")Map<String, Object> queryMap);
}