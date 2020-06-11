package com.loan.web.controller;

import com.loan.framework.pagination.LoanPageAttribute;
import com.loan.framework.pagination.LoanPageList;
import com.loan.framework.utils.FeeUtils;
import com.loan.service.model.ChannelInfo;
import com.loan.service.model.FeeItemInfo;
import com.loan.service.service.FeeItemInfoService;
import com.loan.web.common.CommonData;
import com.loan.web.common.JsonData;
import com.loan.web.vo.channel.ChannelInfoVo;
import com.loan.web.vo.feeitem.FeeItemInfoVo;
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
 * @date 2019-04-23 23:20
 */
@RestController
@RequestMapping("feeItem")
public class FeeItemInfoController {

    @Autowired
    private FeeItemInfoService feeItemInfoService;

    @GetMapping("list")
    public JsonData list(@RequestParam(value = "itemName", required = false) String itemName,
                         @RequestParam(value = "pageNum") Integer pageNum,
                         @RequestParam(value = "pageSize") Integer pageSize) {

        LoanPageAttribute pageAttr = new LoanPageAttribute(pageNum, pageSize);
        Map<String, Object> params = new HashMap<>();
        if (!StringUtils.isEmpty(itemName)) params.put("itemName", itemName);

        LoanPageList<FeeItemInfo> feeItemInfoPageList = this.feeItemInfoService.getFeeItemInfoPageList(params, pageAttr);

        List<FeeItemInfoVo> feeItemInfoVoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(feeItemInfoPageList.getDatas())) {
            feeItemInfoPageList.getDatas().forEach(feeItemInfo -> {
                feeItemInfoVoList.add(this.getVoFromModel(feeItemInfo));
            });
        }

        return JsonData.getSucceed(feeItemInfoVoList, feeItemInfoPageList.getPageInfo());
    }


    @GetMapping("getSingleFeeItem")
    public JsonData getSingleFeeItem(@RequestParam(value = "itemId") Long itemId) {
        FeeItemInfo feeItemInfo = this.feeItemInfoService.getEntityById(itemId);
        if (null == feeItemInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "费用科目不存在");
        return JsonData.getSucceed(this.getVoFromModel(feeItemInfo));
    }

    @PostMapping("addOrUpdateSingleFeeItem")
    public JsonData addOrUpdateSingleChannel(@RequestBody FeeItemInfoVo feeItemInfoVo) {
        if (null != feeItemInfoVo.getItemId()) {
            FeeItemInfo feeItemInfo = this.feeItemInfoService.getEntityById(feeItemInfoVo.getItemId());
            if (null == feeItemInfo)
                return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "费用科目不存在");
        }
        this.feeItemInfoService.saveFeeItemInfo(this.getModelFromVo(feeItemInfoVo));
        return JsonData.getSucceed();
    }

    @PostMapping("deleteFeeItem")
    public JsonData deleteFeeItem(@RequestBody FeeItemInfoVo feeItemInfoVo) {
        if (null == feeItemInfoVo.getItemId()) return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_401);

        FeeItemInfo feeItemInfo = this.feeItemInfoService.getEntityById(feeItemInfoVo.getItemId());
        if (null == feeItemInfo)
            return JsonData.getResult(CommonData.StatusCode.STATUS_CODE_400, "费用科目不存在");

        this.feeItemInfoService.deleteEntityById(feeItemInfoVo.getItemId());
        return JsonData.getSucceed();
    }


    private FeeItemInfoVo getVoFromModel(FeeItemInfo feeItemInfo) {
        FeeItemInfoVo feeItemInfoVo = new FeeItemInfoVo();
        BeanUtils.copyProperties(feeItemInfo, feeItemInfoVo);

        // 转化单价以元为单位
        feeItemInfoVo.setItemPrice(FeeUtils.getYuanFromCent(feeItemInfo.getItemPrice()));
        return feeItemInfoVo;
    }

    private FeeItemInfo getModelFromVo(FeeItemInfoVo feeItemInfoVo) {
        FeeItemInfo feeItemInfo = new FeeItemInfo();
        BeanUtils.copyProperties(feeItemInfoVo, feeItemInfo);

        // 转化单价以分为单位
        feeItemInfo.setItemPrice(FeeUtils.getCentFromYuan(feeItemInfoVo.getItemPrice()));
        return feeItemInfo;
    }
}
