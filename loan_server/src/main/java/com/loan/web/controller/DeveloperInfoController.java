package com.loan.web.controller;

import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.service.model.DeveloperInfo;
import com.loan.service.model.EstateInfo;
import com.loan.service.model.EstateSalesmanInfo;
import com.loan.service.model.dto.DeveloperInfoDto;
import com.loan.service.model.dto.EstateInfoDto;
import com.loan.service.service.DeveloperInfoService;
import com.loan.service.service.EstateInfoService;
import com.loan.service.service.EstateSalesmanInfoService;
import com.loan.web.common.CommonData;
import com.loan.web.common.JsonData;
import com.loan.web.common.LoginInfoHolder;
import com.loan.web.vo.DeveloperEstateInfoPageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/4/26 11:19
 */
@RestController
@RequestMapping("developer")
public class DeveloperInfoController {

    @Autowired
    private EstateInfoService estateInfoService;
    @Autowired
    private DeveloperInfoService developerInfoService;
    @Autowired
    private EstateSalesmanInfoService estateSalesmanInfoService;

    @GetMapping("list")
    public JsonData list(@RequestParam(value = "developerName", required = false) String developerName,
                         @RequestParam(value = "estateName", required = false) String estateName,
                         @RequestParam(value = "pageNum") Integer pageNum,
                         @RequestParam(value = "pageSize") Integer pageSize) {

        LoanPageAttribute pageAttr = new LoanPageAttribute(pageNum, pageSize);
        Map<String, Object> params = new HashMap<>();
        if (!StringUtils.isEmpty(developerName)) params.put("developerName", developerName);
        if (!StringUtils.isEmpty(estateName)) params.put("estateName", estateName);
        LoanPageList<EstateInfoDto> pageList = this.estateInfoService.getDeveloperEstateInfoPageList(params, pageAttr);

        List<DeveloperEstateInfoPageVo> pageVoList = new ArrayList<>();

        if (!CollectionUtils.isEmpty(pageList.getDatas()))
            pageList.getDatas().forEach(dto -> pageVoList.add(getPageVo(dto)));

        return JsonData.getSucceed(pageVoList, pageList.getPageInfo());
    }

    @GetMapping("getDeveloperInfo")
    public JsonData getDeveloperInfo(@RequestParam(value = "developerId") Long developerId) {
        if (null == developerId)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401, "developerId不能为空");

        DeveloperInfo developerInfo = this.developerInfoService.getEntityById(developerId);
        if (null == developerInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "开发商信息不存在");

        DeveloperInfoDto developerInfoDto = this.developerInfoService.getDeveloperInfoDto(developerId);

        return JsonData.getSucceed(developerInfoDto);
    }


    @PostMapping("addOrUpdateDeveloperInfo")
    public JsonData addOrUpdateDeveloperInfo(@RequestBody DeveloperInfoDto developerInfoDto) {
        if (null != developerInfoDto.getDeveloperId()) {
            DeveloperInfo developerInfo = this.developerInfoService.getEntityById(developerInfoDto.getDeveloperId());
            if (null == developerInfo)
                return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "开发商信息不存在");
        }
        developerInfoDto.setCreateUser(LoginInfoHolder.getUserId());
        this.developerInfoService.saveDeveloperInfoDto(developerInfoDto);
        return JsonData.getSucceed();
    }

    @PostMapping("deleteEstateInfo")
    public JsonData deleteFeeItem(@RequestBody DeveloperEstateInfoPageVo vo) {
        if (null == vo.getEstateId()) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401);

        EstateInfo estateInfo = this.estateInfoService.getEntityById(vo.getEstateId());
        if (null == estateInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "楼盘信息不存在");

        this.estateInfoService.deleteEstateInfoById(vo.getEstateId());
        return JsonData.getSucceed();
    }


    /**
     * 获取开发商列表信息
     */
    @GetMapping("getDeveloperList")
    public JsonData getDeveloperList() {
        return JsonData.getSucceed(this.developerInfoService.queryEntityList(new DeveloperInfo()));
    }

    /**
     * 获取楼盘列表信息
     */
    @GetMapping("getEstateList")
    public JsonData getEstateList(@RequestParam("developerId") Long developerId) {
        DeveloperInfo developerInfo = this.developerInfoService.getEntityById(developerId);
        if (null == developerInfo) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "开发商信息不存在");
        List<EstateInfo> estateInfos = this.estateInfoService.queryEntityList(new EstateInfo() {{
            setDeveloperId(developerId);
        }});
        return JsonData.getSucceed(estateInfos);
    }

    /**
     * 获取楼盘销售人员信息
     */
    @GetMapping("getEstateSalesmanList")
    public JsonData getEstateSalesmanList(@RequestParam("estateId") Long estateId) {
        EstateInfo estateInfo = this.estateInfoService.getEntityById(estateId);
        if (null == estateInfo) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "楼盘信息不存在");
        List<EstateSalesmanInfo> salesmanInfos = this.estateSalesmanInfoService.queryEntityList(new EstateSalesmanInfo() {{
            setEstateId(estateId);
        }});
        return JsonData.getSucceed(salesmanInfos);
    }

    private DeveloperEstateInfoPageVo getPageVo(EstateInfoDto estateInfoDto) {
        if (null == estateInfoDto) return null;
        DeveloperEstateInfoPageVo pageVo = new DeveloperEstateInfoPageVo();
        BeanUtils.copyProperties(estateInfoDto, pageVo);
        pageVo.setDeveloperName(estateInfoDto.getDeveloperInfo().getDeveloperName());
        pageVo.setDeveloperAddr(estateInfoDto.getDeveloperInfo().getDeveloperAddr());
        return pageVo;
    }
}
