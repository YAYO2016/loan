package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.CrdtCaseInfo;
import com.framework.mybatis.mysql.pojo.CrdtCaseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrdtCaseInfoMapper {
    int countByExample(CrdtCaseInfoExample example);

    int deleteByExample(CrdtCaseInfoExample example);

    int insert(CrdtCaseInfo record);

    int insertSelective(CrdtCaseInfo record);

    List<CrdtCaseInfo> selectByExample(CrdtCaseInfoExample example);

    int updateByExampleSelective(@Param("record") CrdtCaseInfo record, @Param("example") CrdtCaseInfoExample example);

    int updateByExample(@Param("record") CrdtCaseInfo record, @Param("example") CrdtCaseInfoExample example);
}