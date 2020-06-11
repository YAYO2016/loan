package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.CrdtModifyData;
import com.framework.mybatis.mysql.pojo.CrdtModifyDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrdtModifyDataMapper {
    int countByExample(CrdtModifyDataExample example);

    int deleteByExample(CrdtModifyDataExample example);

    int insert(CrdtModifyData record);

    int insertSelective(CrdtModifyData record);

    List<CrdtModifyData> selectByExample(CrdtModifyDataExample example);

    int updateByExampleSelective(@Param("record") CrdtModifyData record, @Param("example") CrdtModifyDataExample example);

    int updateByExample(@Param("record") CrdtModifyData record, @Param("example") CrdtModifyDataExample example);
}