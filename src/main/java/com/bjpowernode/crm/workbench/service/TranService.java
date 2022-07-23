package com.bjpowernode.crm.workbench.service;

import com.bjpowernode.crm.workbench.domain.FunnelVO;
import com.bjpowernode.crm.workbench.domain.Transaction;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;
import java.util.Map;

/**
 * @Author:大润发杀鱼匠
 * @Date:2022/7/19 22:34 crm-project
 */


public interface TranService {

    List<Transaction> queryTranByConditionForPage(Map<String, Object> map);

    int queryTranCountsByConditionForPage(Map<String, Object> map);

    int saveCreateTran(Map<String, Object> map);

    Transaction queryTranForDetailById(String id);

    List<FunnelVO> queryCountOfTranGroupByStage();
}
