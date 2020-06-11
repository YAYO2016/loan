package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.CfgCaseItemLimit;
import com.framework.mybatis.mysql.pojo.CfgCaseItemLimitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfgCaseItemLimitMapper {
    int countByExample(CfgCaseItemLimitExample example);

    int deleteByExample(CfgCaseItemLimitExample example);

    int insert(CfgCaseItemLimit record);

    int insertSelective(CfgCaseItemLimit record);

    List<CfgCaseItemLimit> selectByExample(CfgCaseItemLimitExample example);

    int updateByExampleSelective(@Param("record") CfgCaseItemLimit record, @Param("example") CfgCaseItemLimitExample example);

    int updateByExample(@Param("record") CfgCaseItemLimit record, @Param("example") CfgCaseItemLimitExample example);
}