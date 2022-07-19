package com.bjpowernode.crm.workbench.web.controller;

import com.bjpowernode.crm.settings.domain.DicValue;
import com.bjpowernode.crm.settings.mapper.DicValueMapper;
import com.bjpowernode.crm.settings.service.DicValueService;
import com.bjpowernode.crm.workbench.domain.Transaction;
import com.bjpowernode.crm.workbench.service.TranService;
import com.bjpowernode.crm.workbench.service.impl.TranServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:大润发杀鱼匠
 * @Date:2022/7/19 18:43 crm-project
 */

@Controller
public class TranController {

    @Autowired
    private DicValueService dicValueService;

    @Autowired
    private TranService tranService;

    @RequestMapping("/workbench/transaction/index.do")
    public String index(HttpServletRequest request) {
        //调用service
        List<DicValue> transactionTypeList = dicValueService.queryDicValueByTypeCode("transactionType");
        List<DicValue> sourceList = dicValueService.queryDicValueByTypeCode("source");
        List<DicValue> stageList = dicValueService.queryDicValueByTypeCode("stage");
        request.setAttribute("transactionTypeList", transactionTypeList);
        request.setAttribute("sourceList", sourceList);
        request.setAttribute("stageList", stageList);
        return "workbench/transaction/index";
    }


    @RequestMapping("/workbench/transaction/queryTranByConditionForPage.do")
    @ResponseBody
    public Object queryTranByConditionForPage(String owner, String name, String customerId, String stage,
    String type, String source, int pageNo, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("owner", owner);
        map.put("name", name);
        map.put("customerId", customerId);
        map.put("stage", stage);
        map.put("type", type);
        map.put("source", source);
        map.put("beginNo", (pageNo - 1) * pageSize);
        map.put("pageSize", pageSize);
        List<Transaction> transactionList = tranService.queryTranByConditionForPage(map);
        int totalRows = tranService.queryTranCountsByConditionForPage(map);
        Map<String, Object> result = new HashMap<>();
        result.put("transactionList",transactionList);
        result.put("totalRows",totalRows);
        return result;
    }
}
