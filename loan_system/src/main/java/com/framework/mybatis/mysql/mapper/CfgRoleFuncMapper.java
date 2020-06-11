package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.CfgRoleFunc;
import com.framework.mybatis.mysql.pojo.CfgRoleFuncExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfgRoleFuncMapper {
    int countByExample(CfgRoleFuncExample example);

    int deleteByExample(CfgRoleFuncExample example);

    int insert(CfgRoleFunc record);

    int insertSelective(CfgRoleFunc record);

    List<CfgRoleFunc> selectByExample(CfgRoleFuncExample example);

    int updateByExampleSelective(@Param("record") CfgRoleFunc record, @Param("example") CfgRoleFuncExample example);

    int updateByExample(@Param("record") CfgRoleFunc record, @Param("example") CfgRoleFuncExample example);
}