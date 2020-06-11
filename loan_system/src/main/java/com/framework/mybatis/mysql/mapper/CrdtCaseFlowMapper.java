package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.CrdtCaseFlow;
import com.framework.mybatis.mysql.pojo.CrdtCaseFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrdtCaseFlowMapper {
    int countByExample(CrdtCaseFlowExample example);

    int deleteByExample(CrdtCaseFlowExample example);

    int insert(CrdtCaseFlow record);

    int insertSelective(CrdtCaseFlow record);

    List<CrdtCaseFlow> selectByExample(CrdtCaseFlowExample example);

    int updateByExampleSelective(@Param("record") CrdtCaseFlow record, @Param("example") CrdtCaseFlowExample example);

    int updateByExample(@Param("record") CrdtCaseFlow record, @Param("example") CrdtCaseFlowExample example);
}