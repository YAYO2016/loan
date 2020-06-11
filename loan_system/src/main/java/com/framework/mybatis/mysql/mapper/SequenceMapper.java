package com.framework.mybatis.mysql.mapper;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface SequenceMapper {
    Map<String, Object>  querySeq(@Param("map") Map<String, Object> queryMap);
    
}