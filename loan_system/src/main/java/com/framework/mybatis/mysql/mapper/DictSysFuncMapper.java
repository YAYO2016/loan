package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.DictSysFunc;
import com.framework.mybatis.mysql.pojo.DictSysFuncExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DictSysFuncMapper {
    int countByExample(DictSysFuncExample example);

    int deleteByExample(DictSysFuncExample example);

    int insert(DictSysFunc record);

    int insertSelective(DictSysFunc record);

    List<DictSysFunc> selectByExample(DictSysFuncExample example);

    int updateByExampleSelective(@Param("record") DictSysFunc record, @Param("example") DictSysFuncExample example);

    int updateByExample(@Param("record") DictSysFunc record, @Param("example") DictSysFuncExample example);
    
    List<Map<String, Object>> queryList(@Param("map")Map<String, Object> map);
}