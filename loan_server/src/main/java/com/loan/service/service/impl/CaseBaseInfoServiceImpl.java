package com.loan.service.service.impl;

import com.loan.framework.pagination.LoanPage;
import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.service.dao.ISingleTableDao;
import com.loan.framework.service.service.AbstractLoanService;
import com.loan.service.dao.*;
import com.loan.service.enums.*;
import com.loan.service.model.*;
import com.loan.service.model.dto.CaseBaseInfoDto;
import com.loan.service.model.dto.CasePageInfoDto;
import com.loan.service.service.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author GuoKang
 * @date 2019-05-06 21:40
 */
@Service
public class CaseBaseInfoServiceImpl extends AbstractLoanService<CaseBaseInfo> implements CaseBaseInfoService {

    @Autowired
    private CaseBaseInfoDao caseBaseInfoDao;
    @Autowired
    private CaseLoanInfoService caseLoanInfoService;
    @Autowired
    private CaseLoanInfoDao caseLoanInfoDao;
    @Autowired
    private CaseNewHouseInfoService caseNewHouseInfoService;
    @Autowired
    private CaseNewHouseInfoDao caseNewHouseInfoDao;
    @Autowired
    private CaseSecondHandHouseInfoService caseSecondHandHouseInfoService;
    @Autowired
    private CaseSecondHandHouseInfoDao caseSecondHandHouseInfoDao;
    @Autowired
    private CaseCustInfoService caseCustInfoService;
    @Autowired
    private CaseOperateLogService caseOperateLogService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private CaseStaffsService caseStaffsService;

    @Override
    protected ISingleTableDao<CaseBaseInfo> getMyBatisRepository() {
        return caseBaseInfoDao;
    }

    @Override
    protected CaseBaseInfo constructPkEntity(Long id) {
        return new CaseBaseInfo() {{
            setPk(id);
        }};
    }

    @Override
    protected Object getPk(CaseBaseInfo caseBaseInfo) {
        return caseBaseInfo.getCaseId();
    }

    @Override
    public CaseBaseInfoDto getCaseBaseInfoDtoByCaseId(Long caseId) {
        CaseBaseInfo caseBaseInfo = this.getEntityById(caseId);
        if (null == caseBaseInfo) return null;

        CaseBaseInfoDto caseBaseInfoDto = new CaseBaseInfoDto();
        BeanUtils.copyProperties(caseBaseInfo, caseBaseInfoDto);

        CaseStaffs caseStaffs = caseStaffsService.getEntityById(caseId);

        caseBaseInfoDto.setLoanInfo(this.caseLoanInfoService.getEntityById(caseId));
        caseBaseInfoDto.setNewHouseInfo(this.caseNewHouseInfoService.getEntityById(caseId));
        caseBaseInfoDto.setSecondHandHouseInfo(this.caseSecondHandHouseInfoService.getEntityById(caseId));
        caseBaseInfoDto.setCustInfos(this.caseCustInfoService.queryEntityList(new CaseCustInfo() {{
            setCaseId(caseId);
        }}));
        if (null != caseStaffs && null != caseStaffs.getBusinessId())
            caseBaseInfoDto.setBusinessUser(this.userInfoService.getEntityById(caseStaffs.getBusinessId()));

        return caseBaseInfoDto;
    }

    @Transactional
    @Override
    public CaseBaseInfoDto saveCaseBaseInfoDto(Long userId, CaseBaseInfoDto caseBaseInfoDto) {
        Long caseId = caseBaseInfoDto.getCaseId();
        Date now = new Date();
        if (null == caseId) {
            // 新增
            caseBaseInfoDto.setIsReform(ReformStatus.NON_REFORM);
            caseBaseInfoDto.setCreateUser(userId);
            caseBaseInfoDto.setCreateTime(now);
            caseBaseInfoDto.setModifyTime(now);
            caseBaseInfoDto.setCaseStatus(CaseStatusDict.STATUS_101);
            this.create(caseBaseInfoDto);
            caseId = caseBaseInfoDto.getCaseId();

            if (null != caseBaseInfoDto.getLoanInfo()) {
                caseBaseInfoDto.getLoanInfo().setCaseId(caseId);
                caseBaseInfoDto.getLoanInfo().setCreateTime(now);
                caseBaseInfoDto.getLoanInfo().setModifyTime(now);
                this.caseLoanInfoDao.insert(caseBaseInfoDto.getLoanInfo());
            }
            if (null != caseBaseInfoDto.getNewHouseInfo()) {
                caseBaseInfoDto.getNewHouseInfo().setCaseId(caseId);
                caseBaseInfoDto.getNewHouseInfo().setCreateTime(now);
                this.caseNewHouseInfoDao.insert(caseBaseInfoDto.getNewHouseInfo());
            }
            if (null != caseBaseInfoDto.getSecondHandHouseInfo()) {
                caseBaseInfoDto.getSecondHandHouseInfo().setCaseId(caseId);
                caseBaseInfoDto.getSecondHandHouseInfo().setCreateTime(now);
                this.caseSecondHandHouseInfoDao.insert(caseBaseInfoDto.getSecondHandHouseInfo());
            }

            // 根据婚姻状况过滤干系人数据，找到买方主贷人
            if (null != caseBaseInfoDto.getCustInfos()) {
                final Long finalCaseId = caseId;
                caseBaseInfoDto.getCustInfos()
                        .stream()
                        .filter(caseCustInfo -> CaseCustomerType.BUYER_MAIN_CREDIT.equals(caseCustInfo.getCaseCustType()))
                        .findFirst()
                        .ifPresent(caseCustInfo -> {
                            caseCustInfo.setCaseId(finalCaseId);
                            caseCustInfo.setCreateTime(now);
                            this.caseCustInfoService.create(caseCustInfo);
                        });
            }

            // 写入CaseStaffs，先删除原来记录
            CaseStaffs caseStaffs = new CaseStaffs();
            caseStaffs.setCaseId(caseId);
            caseStaffs.setCreateId(userId);
            caseStaffs.setBusinessId(null != caseBaseInfoDto.getBusinessUser() ?
                    caseBaseInfoDto.getBusinessUser().getUserId() : null);
            caseStaffsService.createOrUpdateCaseStaffsInfo(caseStaffs);

            List<CaseOperateLog> logs = caseOperateLogService.getLogsByCaseId(caseBaseInfoDto.getCaseId());
            if (CollectionUtils.isEmpty(logs)) {
                // 增加一条流程进展信息
                CaseOperateLog caseOperateLog = new CaseOperateLog();
                caseOperateLog.setCaseId(caseId);
                caseOperateLog.setCaseStatus(caseBaseInfoDto.getCaseStatus());
                caseOperateLog.setOperateType(CaseOperateType.CREATE);
                caseOperateLog.setOperateResult(CaseOperateResult.PASS);
                caseOperateLog.setOperateRemark(null);
                caseOperateLog.setOperatorId(caseBaseInfoDto.getCreateUser());
                caseOperateLog.setNextOperatorId(caseBaseInfoDto.getCreateUser());
                caseOperateLog.setOperateTime(now);
                caseOperateLogService.create(caseOperateLog);
            }
        } else {
            // 修改
            CaseBaseInfo caseBaseInfo = this.getEntityById(caseId);
            caseBaseInfoDto.setCreateUser(caseBaseInfo.getCreateUser());
            caseBaseInfoDto.setModifyTime(now);
            this.modifyEntityById(caseBaseInfoDto);


            caseBaseInfoDto.getLoanInfo().setCaseId(caseId);
            caseBaseInfoDto.getLoanInfo().setModifyTime(now);
            this.caseLoanInfoService.modifyEntityById(caseBaseInfoDto.getLoanInfo());

            if (CaseSubType.NEW_HOUSE.equals(caseBaseInfoDto.getCaseSubType())) {
                // 选择了一手房， 清空二手房信息、更新一手房信息
                caseBaseInfoDto.getNewHouseInfo().setCaseId(caseId);
                if (null == this.caseNewHouseInfoService.getEntityById(caseId)) {
                    this.caseNewHouseInfoDao.insert(caseBaseInfoDto.getNewHouseInfo());
                } else {
                    this.caseNewHouseInfoService.modifyEntityById(caseBaseInfoDto.getNewHouseInfo());
                }
                this.caseSecondHandHouseInfoService.deleteEntityById(caseId);
            }

            if (CaseSubType.SECOND_HAND_HOUSE.equals(caseBaseInfoDto.getCaseSubType())) {
                // 选择了二手房， 清空一手房信息、更新二手房信息
                caseBaseInfoDto.getSecondHandHouseInfo().setCaseId(caseId);
                if (null == this.caseSecondHandHouseInfoService.getEntityById(caseId)) {
                    this.caseSecondHandHouseInfoDao.insert(caseBaseInfoDto.getSecondHandHouseInfo());
                } else {
                    this.caseSecondHandHouseInfoService.modifyEntityById(caseBaseInfoDto.getSecondHandHouseInfo());
                }
                this.caseNewHouseInfoService.deleteEntityById(caseId);
            }

            // 根据婚姻状况过滤干系人数据，找到买方主贷人
            final Long finalCaseId = caseId;
            caseBaseInfoDto.getCustInfos()
                    .stream()
                    .filter(caseCustInfo -> CaseCustomerType.BUYER_MAIN_CREDIT.equals(caseCustInfo.getCaseCustType()))
                    .findFirst()
                    .ifPresent(caseCustInfo -> {
                        List<CaseCustInfo> caseCustInfos = this.caseCustInfoService.queryEntityList(new CaseCustInfo() {{
                            setCaseId(finalCaseId);
                            setCaseCustType(CaseCustomerType.BUYER_MAIN_CREDIT);
                        }});
                        if (!CollectionUtils.isEmpty(caseCustInfos)) {
                            caseCustInfo.setCustId(caseCustInfos.get(0).getCustId());
                            this.caseCustInfoService.modifyEntityById(caseCustInfo);
                        }
                    });


            // 更新渠道人员，先删除原来记录
            CaseStaffs caseStaffs = caseStaffsService.getEntityById(caseId);
//            if (null == caseStaffs) caseStaffs = new CaseStaffs() {{
//                setCaseId(finalCaseId);
//            }};
            caseStaffs.setBusinessId(null != caseBaseInfoDto.getBusinessUser() ?
                    caseBaseInfoDto.getBusinessUser().getUserId() : null);
            caseStaffsService.createOrUpdateCaseStaffsInfo(caseStaffs);
        }
        return caseBaseInfoDto;
    }

    @Override
    public LoanPageList<CaseBaseInfoDto> getCaseBaseInfoDtoPageList(Map<String, Object> params, LoanPageAttribute pageAttr) {
        if (null == pageAttr) {
            pageAttr = LoanPageAttribute.getInstance();
        }
        params.put("pageSize", pageAttr.getPageSize());
        params.put("offSet", pageAttr.getBegin());
        int count;
        if ("3".equalsIgnoreCase((String) params.get("pageType"))) {
            // 我参与的
            count = this.caseBaseInfoDao.countAllMyCasePageInfo(params);
        } else {
            count = this.caseBaseInfoDao.countCasePageInfo(params);
        }
        if (0 == count) {
            return LoanPageList.getEmptyInstance();
        }
        List<CaseBaseInfo> list;
        if ("3".equalsIgnoreCase((String) params.get("pageType"))) {
            // 我参与的
            list = this.caseBaseInfoDao.listAllMyCasePageInfo(params);
        } else {
            list = this.caseBaseInfoDao.listCasePageInfo(params);
        }

        List<CaseBaseInfoDto> dtoList = new ArrayList<>();

        Objects.requireNonNull(list).forEach(caseBaseInfo -> {
            CaseBaseInfoDto dto = new CaseBaseInfoDto();
            BeanUtils.copyProperties(caseBaseInfo, dto);

            dto.setLoanInfo(caseLoanInfoService.getEntityById(caseBaseInfo.getCaseId()));
            dto.setNewHouseInfo(caseNewHouseInfoService.getEntityById(caseBaseInfo.getCaseId()));
            dto.setSecondHandHouseInfo(caseSecondHandHouseInfoService.getEntityById(caseBaseInfo.getCaseId()));
            dto.setCustInfos(this.caseCustInfoService.queryEntityList(new CaseCustInfo() {{
                setCaseId(caseBaseInfo.getCaseId());
            }}));

            dtoList.add(dto);
        });

        return LoanPageList.getInstance(dtoList, LoanPage.getInstance(pageAttr, count));
    }

    @Override
    public LoanPageList<CasePageInfoDto> getAllCaseList(Map<String, Object> params, LoanPageAttribute pageAttr) {
        if (null == pageAttr) {
            pageAttr = LoanPageAttribute.getInstance();
        }
        params.put("pageSize", pageAttr.getPageSize());
        params.put("offSet", pageAttr.getBegin());
        int count = this.caseBaseInfoDao.countAllCasePageInfo(params);
        if (0 == count) {
            return LoanPageList.getEmptyInstance();
        }
        List<CasePageInfoDto> list = this.caseBaseInfoDao.listAllCasePageInfo(params);
        return LoanPageList.getInstance(list, LoanPage.getInstance(pageAttr, count));
    }

	@Override
	public void delCase(Map<String, Object> params) {
		caseBaseInfoDao.delCase(params);
	}

	@Override
	public List<Map<String, Object>> getButtonList(Map<String, Object> params) {
		String roleId=params.get("role").toString();
		List<Map<String, Object>>  buttonList=new ArrayList<Map<String,Object>>();
		
		Map<String, Object>  button=null;
		Map<String, Object>  button1=null;
		Map<String, Object>  button2=null;
		Map<String, Object>  button3=null;
		
		List<String> list=null;
		List<String> list1=null;
		List<String> list2=null;
		List<String> list3=null;
		
		if("R0201".equals(roleId)){//签单
			button=new HashMap<String, Object>();
			button1=new HashMap<String, Object>();
			button2=new HashMap<String, Object>();
			button3=new HashMap<String, Object>();
			
			list=new ArrayList<String>();
			list1=new ArrayList<String>();
			list2=new ArrayList<String>();
			list3=new ArrayList<String>();
			
			button.put("btnName","新增案子");
			button.put("btnType","1_1");
			button1.put("btnName","面签通知");
			button1.put("btnType","1_2");
			button2.put("btnName","审批通过");
			button2.put("btnType","1_3");
			button3.put("btnName","过户抵押");
			button3.put("btnType","1_4");
			list.add("STATUS_101");
			list.add("STATUS_104");
			list.add("STATUS_106");
			list.add("STATUS_116");
			
			list1.add("STATUS_108");
			
			list2.add("STATUS_112");
			list2.add("STATUS_105");
			
			list3.add("STATUS_117");
			params.put("caseStatus", list);
			button.put("btnCount", caseBaseInfoDao.getButtonList(params));
			
			params.put("caseStatus", list1);
			button1.put("btnCount", caseBaseInfoDao.getButtonList(params));
			
			params.put("caseStatus", list2);
			button2.put("btnCount", caseBaseInfoDao.getButtonList(params));
			
			params.put("caseStatus", list3);
			button3.put("btnCount", caseBaseInfoDao.getButtonList(params));
			
			buttonList.add(button);
			buttonList.add(button1);
			buttonList.add(button2);
			buttonList.add(button3);
			
		}else if("R0301".equals(roleId)){//风控
			button=new HashMap<String, Object>();
			button1=new HashMap<String, Object>();
			list=new ArrayList<String>();
			list1=new ArrayList<String>();
			
			button.put("btnName","内部审核");
			button.put("btnType","2_1");
			button1.put("btnName","银行审批");
			button1.put("btnType","2_2");
			list.add("STATUS_102");
			
			list1.add("STATUS_110");
			list1.add("STATUS_109");
			params.put("caseStatus", list);
			button.put("btnCount", caseBaseInfoDao.getButtonList(params));
			
			params.put("caseStatus", list1);
			button1.put("btnCount", caseBaseInfoDao.getButtonList(params));
			buttonList.add(button);
			buttonList.add(button1);
			
		}else if("R0401".equals(roleId)){//财务
			
			button=new HashMap<String, Object>();
			button1=new HashMap<String, Object>();
			list=new ArrayList<String>();
			list1=new ArrayList<String>();
			
			button.put("btnName","初审");
			button.put("btnType","3_1");
			button1.put("btnName","复审");
			button1.put("btnType","3_2");
			list.add("STATUS_103");
			list1.add("STATUS_121");
			
			params.put("caseStatus", list);
			button.put("btnCount", caseBaseInfoDao.getButtonList(params));
			
			params.put("caseStatus", list1);
			button1.put("btnCount", caseBaseInfoDao.getButtonList(params));
			buttonList.add(button);
			buttonList.add(button1);
			
		}else if("R0601".equals(roleId)){//外勤
			
			button=new HashMap<String, Object>();
			button1=new HashMap<String, Object>();
			button2=new HashMap<String, Object>();
			list=new ArrayList<String>();
			list1=new ArrayList<String>();
			list2=new ArrayList<String>();
			
			button.put("btnName","送件");
			button.put("btnType","4_1");
			button1.put("btnName","取件");
			button1.put("btnType","4_2");
			button2.put("btnName","放款");
			button2.put("btnType","4_3");
			
			
			list.add("STATUS_105");
			list.add("STATUS_107");
			
			list1.add("STATUS_116");
			list1.add("STATUS_111");
			list1.add("STATUS_112");
			list1.add("STATUS_114");
			list1.add("STATUS_113");
			
			list2.add("STATUS_120");
			list2.add("STATUS_121");
			
			params.put("caseStatus", list);
			button.put("btnCount", caseBaseInfoDao.getButtonList(params));
			
			params.put("caseStatus", list1);
			button1.put("btnCount", caseBaseInfoDao.getButtonList(params));
			
		
			params.put("caseStatus", list2);
			button2.put("btnCount", caseBaseInfoDao.getButtonList(params));
			
			buttonList.add(button);
			buttonList.add(button1);
			buttonList.add(button2);
		}
		return buttonList;
	}

	@Override
	public List<String> getCaseStatus(String btnType) {
		List<String>  caseStatus =new ArrayList<String>();
		if("1_1".equals(btnType)){
			caseStatus.add("STATUS_101");
			caseStatus.add("STATUS_104");
			caseStatus.add("STATUS_106");
			caseStatus.add("STATUS_116");
		}else if("1_2".equals(btnType)){
			caseStatus.add("STATUS_108");
		}else if("1_3".equals(btnType)){
			caseStatus.add("STATUS_112");
			caseStatus.add("STATUS_105");
		}else if("1_4".equals(btnType)){
			caseStatus.add("STATUS_117");
		}else if("2_1".equals(btnType)){
			caseStatus.add("STATUS_102");
		}else if("2_2".equals(btnType)){
			caseStatus.add("STATUS_110");
			caseStatus.add("STATUS_109");
		}else if("3_1".equals(btnType)){
			caseStatus.add("STATUS_103");
		}else if("3_2".equals(btnType)){
			caseStatus.add("STATUS_121");
		}else if("4_1".equals(btnType)){
			caseStatus.add("STATUS_105");
			caseStatus.add("STATUS_107");
		}else if("4_2".equals(btnType)){
			caseStatus.add("STATUS_116");
			caseStatus.add("STATUS_111");
			caseStatus.add("STATUS_112");
			caseStatus.add("STATUS_114");
			caseStatus.add("STATUS_113");
		}else if("4_3".equals(btnType)){
			caseStatus.add("STATUS_120");
			caseStatus.add("STATUS_121");
		}
		
		return caseStatus;
	}

	@Override
	public List<CasePageInfoDto> getAllCaseList(Map<String, Object> params) {
		return caseBaseInfoDao.getAllCaseListExport(params);
	}
}
