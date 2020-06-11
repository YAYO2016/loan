package com.framework.mybatis.mysql.mapper;

import com.framework.mybatis.mysql.pojo.CrdtSmsSend;
import com.framework.mybatis.mysql.pojo.CrdtSmsSendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrdtSmsSendMapper {
    int countByExample(CrdtSmsSendExample example);

    int deleteByExample(CrdtSmsSendExample example);

    int insert(CrdtSmsSend record);

    int insertSelective(CrdtSmsSend record);

    List<CrdtSmsSend> selectByExample(CrdtSmsSendExample example);

    int updateByExampleSelective(@Param("record") CrdtSmsSend record, @Param("example") CrdtSmsSendExample example);

    int updateByExample(@Param("record") CrdtSmsSend record, @Param("example") CrdtSmsSendExample example);
}