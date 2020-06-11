package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.DictCaseFlow;
import com.framework.mybatis.mysql.pojo.DictCaseFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictCaseFlowMapper {
    int countByExample(DictCaseFlowExample example);

    int deleteByExample(DictCaseFlowExample example);

    int insert(DictCaseFlow record);

    int insertSelective(DictCaseFlow record);

    List<DictCaseFlow> selectByExample(DictCaseFlowExample example);

    int updateByExampleSelective(@Param("record") DictCaseFlow record, @Param("example") DictCaseFlowExample example);

    int updateByExample(@Param("record") DictCaseFlow record, @Param("example") DictCaseFlowExample example);
}