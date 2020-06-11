package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.CrdtDataInfo;
import com.framework.mybatis.mysql.pojo.CrdtDataInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrdtDataInfoMapper {
    int countByExample(CrdtDataInfoExample example);

    int deleteByExample(CrdtDataInfoExample example);

    int insert(CrdtDataInfo record);

    int insertSelective(CrdtDataInfo record);

    List<CrdtDataInfo> selectByExample(CrdtDataInfoExample example);

    int updateByExampleSelective(@Param("record") CrdtDataInfo record, @Param("example") CrdtDataInfoExample example);

    int updateByExample(@Param("record") CrdtDataInfo record, @Param("example") CrdtDataInfoExample example);
}