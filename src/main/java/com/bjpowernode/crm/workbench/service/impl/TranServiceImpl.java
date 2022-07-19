package com.bjpowernode.crm.workbench.service.impl;

import com.bjpowernode.crm.workbench.domain.Transaction;
import com.bjpowernode.crm.workbench.mapper.TransactionMapper;
import com.bjpowernode.crm.workbench.service.TranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author:大润发杀鱼匠
 * @Date:2022/7/19 22:35 crm-project
 */

@Service("tranService")
public class TranServiceImpl implements TranService {

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public List<Transaction> queryTranByConditionForPage(Map<String, Object> map) {
        return transactionMapper.selectTranByConditionForPage(map);
    }

    @Override
    public int queryTranCountsByConditionForPage(Map<String, Object> map) {
        return transactionMapper.selectTranCountsByConditionForPage(map);
    }
}
