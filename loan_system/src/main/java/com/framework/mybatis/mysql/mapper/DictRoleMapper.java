package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.DictRole;
import com.framework.mybatis.mysql.pojo.DictRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictRoleMapper {
    int countByExample(DictRoleExample example);

    int deleteByExample(DictRoleExample example);

    int insert(DictRole record);

    int insertSelective(DictRole record);

    List<DictRole> selectByExample(DictRoleExample example);

    int updateByExampleSelective(@Param("record") DictRole record, @Param("example") DictRoleExample example);

    int updateByExample(@Param("record") DictRole record, @Param("example") DictRoleExample example);
}