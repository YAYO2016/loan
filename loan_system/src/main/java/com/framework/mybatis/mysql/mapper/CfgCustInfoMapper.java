package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.CfgCustInfo;
import com.framework.mybatis.mysql.pojo.CfgCustInfoExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CfgCustInfoMapper {
    int countByExample(CfgCustInfoExample example);

    int deleteByExample(CfgCustInfoExample example);

    int insert(CfgCustInfo record);

    int insertSelective(CfgCustInfo record);

    List<CfgCustInfo> selectByExample(CfgCustInfoExample example);

    int updateByExampleSelective(@Param("record") CfgCustInfo record, @Param("example") CfgCustInfoExample example);

    int updateByExample(@Param("record") CfgCustInfo record, @Param("example") CfgCustInfoExample example);
    
    List<Map<String, Object>> queryList(@Param("map")Map<String, Object> map);
    
    
}