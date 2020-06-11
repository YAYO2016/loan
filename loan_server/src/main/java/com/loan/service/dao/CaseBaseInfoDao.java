package com.loan.service.dao;

import com.loan.framework.service.dao.LoanDao;
import com.loan.service.model.CaseBaseInfo;
import com.loan.service.model.dto.CasePageInfoDto;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019-05-06 21:33
 */
@Component
public interface CaseBaseInfoDao extends LoanDao<CaseBaseInfo> {
    /**
     * 待办任务
     */
    Integer countCasePageInfo(Map<String, Object> params);

    List<CaseBaseInfo> listCasePageInfo(Map<String, Object> params);

    /**
     * 我参与的
     */
    Integer countAllMyCasePageInfo(Map<String, Object> params);

    List<CaseBaseInfo> listAllMyCasePageInfo(Map<String, Object> params);

    /**
     * 全部案子列表
     **/
    Integer countAllCasePageInfo(Map<String, Object> params);
    /**
     * 全部案子列表
     **/
    List<CasePageInfoDto> listAllCasePageInfo(Map<String, Object> params);
    
    /**
     * 删除
     * @param params
     */
    void delCase(Map<String, Object> params);
    
     int getButtonList(Map<String, Object> params);
     
     /**
      * 到处当前列表
      **/
     List<CasePageInfoDto>  getAllCaseListExport(Map<String, Object> params);
}
