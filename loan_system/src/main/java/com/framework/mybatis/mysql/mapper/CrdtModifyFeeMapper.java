package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.CrdtModifyFee;
import com.framework.mybatis.mysql.pojo.CrdtModifyFeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrdtModifyFeeMapper {
    int countByExample(CrdtModifyFeeExample example);

    int deleteByExample(CrdtModifyFeeExample example);

    int insert(CrdtModifyFee record);

    int insertSelective(CrdtModifyFee record);

    List<CrdtModifyFee> selectByExample(CrdtModifyFeeExample example);

    int updateByExampleSelective(@Param("record") CrdtModifyFee record, @Param("example") CrdtModifyFeeExample example);

    int updateByExample(@Param("record") CrdtModifyFee record, @Param("example") CrdtModifyFeeExample example);
}