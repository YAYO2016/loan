package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.CfgUserRole;
import com.framework.mybatis.mysql.pojo.CfgUserRoleExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CfgUserRoleMapper {
    int countByExample(CfgUserRoleExample example);

    int deleteByExample(CfgUserRoleExample example);

    int insert(CfgUserRole record);

    int insertSelective(CfgUserRole record);

    List<CfgUserRole> selectByExample(CfgUserRoleExample example);

    int updateByExampleSelective(@Param("record") CfgUserRole record, @Param("example") CfgUserRoleExample example);

    int updateByExample(@Param("record") CfgUserRole record, @Param("example") CfgUserRoleExample example);

    List<Map<String, Object>> queryList(@Param("map")Map<String, Object> map);
}