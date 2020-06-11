package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.DictArea;
import com.framework.mybatis.mysql.pojo.DictAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictAreaMapper {
    int countByExample(DictAreaExample example);

    int deleteByExample(DictAreaExample example);

    int insert(DictArea record);

    int insertSelective(DictArea record);

    List<DictArea> selectByExample(DictAreaExample example);

    int updateByExampleSelective(@Param("record") DictArea record, @Param("example") DictAreaExample example);

    int updateByExample(@Param("record") DictArea record, @Param("example") DictAreaExample example);
}