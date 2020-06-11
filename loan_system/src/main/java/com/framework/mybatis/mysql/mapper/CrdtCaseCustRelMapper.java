package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.CrdtCaseCustRel;
import com.framework.mybatis.mysql.pojo.CrdtCaseCustRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrdtCaseCustRelMapper {
    int countByExample(CrdtCaseCustRelExample example);

    int deleteByExample(CrdtCaseCustRelExample example);

    int insert(CrdtCaseCustRel record);

    int insertSelective(CrdtCaseCustRel record);

    List<CrdtCaseCustRel> selectByExample(CrdtCaseCustRelExample example);

    int updateByExampleSelective(@Param("record") CrdtCaseCustRel record, @Param("example") CrdtCaseCustRelExample example);

    int updateByExample(@Param("record") CrdtCaseCustRel record, @Param("example") CrdtCaseCustRelExample example);
}