package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.CfgOrg;
import com.framework.mybatis.mysql.pojo.CfgOrgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfgOrgMapper {
    int countByExample(CfgOrgExample example);

    int deleteByExample(CfgOrgExample example);

    int insert(CfgOrg record);

    int insertSelective(CfgOrg record);

    List<CfgOrg> selectByExample(CfgOrgExample example);

    int updateByExampleSelective(@Param("record") CfgOrg record, @Param("example") CfgOrgExample example);

    int updateByExample(@Param("record") CfgOrg record, @Param("example") CfgOrgExample example);
}