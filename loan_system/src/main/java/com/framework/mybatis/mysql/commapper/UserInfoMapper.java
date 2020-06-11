package com.framework.mybatis.mysql.commapper;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface UserInfoMapper {
	List<Map<String,Object>> selectUserInfo(String id);
	
	List<Map<String,Object>> selectMenuInfo(List<String> roles);
	
}