package com.loan.web.controller;

import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.service.enums.MaterialBelong;
import com.loan.service.model.MaterialInfo;
import com.loan.service.service.MaterialInfoService;
import com.loan.web.common.CommonData;
import com.loan.web.common.JsonData;
import com.loan.web.common.LoginInfoHolder;
import com.loan.web.vo.material.MaterialInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GuoKang
 * @date 2019/4/25 11:21
 */
@RestController
@RequestMapping("/material")
public class MaterialInfoController {

    @Autowired
    private MaterialInfoService materialInfoService;


    @GetMapping("list")
    public JsonData list(@RequestParam(value = "materialName", required = false) String materialName,
//                         @RequestParam(value = "materialBelong", required = false) MaterialBelong materialBelong,
                         @RequestParam(value = "pageNum") Integer pageNum,
                         @RequestParam(value = "pageSize") Integer pageSize) {

        LoanPageAttribute pageAttr = new LoanPageAttribute(pageNum, pageSize);
        Map<String, Object> params = new HashMap<>();
        if (!StringUtils.isEmpty(materialName)) params.put("materialName", materialName);
//        if (!StringUtils.isEmpty(materialBelong)) params.put("materialBelong", materialBelong);

        LoanPageList<MaterialInfo> materialInfoPageList = this.materialInfoService.getMaterialInfoPageList(params, pageAttr);

        return JsonData.getSucceed(materialInfoPageList.getDatas(), materialInfoPageList.getPageInfo());
    }

    @GetMapping("getSingleMaterial")
    public JsonData getSingleMaterial(@RequestParam(value = "materialId") Long materialId) {
        MaterialInfo materialInfo = this.materialInfoService.getEntityById(materialId);
        if (null == materialInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "材料信息不存在");

        MaterialInfoVo materialInfoVo = new MaterialInfoVo();
        BeanUtils.copyProperties(materialInfo, materialInfoVo);
        return JsonData.getSucceed(materialInfoVo);
    }

    @PostMapping("addOrUpdateSingleMaterial")
    public JsonData addOrUpdateSingleMaterial(@RequestBody MaterialInfoVo materialInfoVo) {
        if (null != materialInfoVo.getMaterialId()) {
            MaterialInfo materialInfo = this.materialInfoService.getEntityById(materialInfoVo.getMaterialId());
            if (null == materialInfo)
                return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "材料信息不存在");
        }

        MaterialInfo materialInfo = new MaterialInfo();
        BeanUtils.copyProperties(materialInfoVo, materialInfo);
        materialInfo.setCreateUser(LoginInfoHolder.getUserId());
        this.materialInfoService.saveSingleMaterial(materialInfo);
        return JsonData.getSucceed();
    }

    @PostMapping("deleteMaterial")
    public JsonData deleteChannel(@RequestBody MaterialInfoVo materialInfoVo) {
        if (null == materialInfoVo.getMaterialId()) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401);
        MaterialInfo materialInfo = this.materialInfoService.getEntityById(materialInfoVo.getMaterialId());
        if (null == materialInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "材料信息不存在");

        this.materialInfoService.deleteEntityById(materialInfo.getMaterialId());
        return JsonData.getSucceed();
    }
}

