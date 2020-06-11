package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.DictBank;
import com.framework.mybatis.mysql.pojo.DictBankExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DictBankMapper {
    int countByExample(DictBankExample example);

    int deleteByExample(DictBankExample example);

    int insert(DictBank record);

    int insertSelective(DictBank record);

    List<DictBank> selectByExample(DictBankExample example);

    int updateByExampleSelective(@Param("record") DictBank record, @Param("example") DictBankExample example);

    int updateByExample(@Param("record") DictBank record, @Param("example") DictBankExample example);

    List<Map<String, Object>> queryList(@Param("map")Map<String, Object> map);
}