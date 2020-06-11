package com.loan.service.dao;

import com.loan.framework.service.dao.LoanDao;
import com.loan.service.model.MessageInfo;
import com.loan.service.model.dto.MessageInfoDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/9/4 11:37
 */
@Component
public interface MessageManageDao extends LoanDao<MessageInfo> {
    Integer countMessageInfoDto(Map<String, Object> params);

    List<MessageInfoDto> listMessageInfoDto(Map<String, Object> params);
}
