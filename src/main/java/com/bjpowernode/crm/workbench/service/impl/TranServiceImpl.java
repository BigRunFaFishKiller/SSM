package com.bjpowernode.crm.workbench.service.impl;

import com.bjpowernode.crm.commons.constant.Constants;
import com.bjpowernode.crm.commons.utils.DataUtils;
import com.bjpowernode.crm.commons.utils.UUIDUtils;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.workbench.domain.Customer;
import com.bjpowernode.crm.workbench.domain.TranHistory;
import com.bjpowernode.crm.workbench.domain.Transaction;
import com.bjpowernode.crm.workbench.mapper.CustomerMapper;
import com.bjpowernode.crm.workbench.mapper.TranHistoryMapper;
import com.bjpowernode.crm.workbench.mapper.TransactionMapper;
import com.bjpowernode.crm.workbench.service.TranService;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author:大润发杀鱼匠
 * @Date:2022/7/19 22:35 crm-project
 */

@Service("tranService")
public class TranServiceImpl implements TranService {

    @Autowired
    private TranHistoryMapper tranHistoryMapper;

    @Autowired
    private CustomerMapper customerMapper;

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

    @Override
    public int saveCreateTran(Map<String, Object> map) {
        User user = (User) map.get(Constants.SESSION_USER);
        String customerName = (String) map.get("customerName");
        Customer customer = customerMapper.selectCustomerByName(customerName);
        if(customer == null) {
            customer = new Customer();
            customer.setOwner(user.getId());
            customer.setName(customerName);
            customer.setId(UUIDUtils.getUUID());
            customer.setCreateTime(DataUtils.formateDateTime(new Date()));
            customer.setCreateBy(user.getId());
            customerMapper.insertCustomer(customer);
        }
        Transaction transaction = new Transaction();
        transaction.setStage((String) map.get("stage"));
        transaction.setOwner((String) map.get("owner"));
        transaction.setName((String) map.get("name"));
        transaction.setNextContactTime((String) map.get("nextContactTime"));
        transaction.setMoney((String) map.get("money"));
        transaction.setId(UUIDUtils.getUUID());
        transaction.setExpectedDate((String) map.get("expectedDate"));
        transaction.setCustomerId(customer.getId());
        transaction.setCreateTime(DataUtils.formateDateTime(new Date()));
        transaction.setCreateBy(user.getId());
        transaction.setSource((String) map.get("source"));
        transaction.setContactSummary((String) map.get("contactSummary"));
        transaction.setContactsId((String) map.get("contactsId"));
        transaction.setActivityId((String) map.get("activityId"));
        transaction.setDescription((String) map.get("description"));
        transaction.setType((String) map.get("type"));
        int i = transactionMapper.insertTran(transaction);
        //保存交易历史
        TranHistory tranHistory = new TranHistory();
        tranHistory.setStage((String) map.get("stage"));
        tranHistory.setMoney((String) map.get("money"));
        tranHistory.setId(UUIDUtils.getUUID());
        tranHistory.setExpectedDate((String) map.get("expectedDate"));
        tranHistory.setCreateTime(DataUtils.formateDateTime(new Date()));
        tranHistory.setCreateBy(user.getId());
        tranHistory.setTranId(transaction.getId());
        tranHistoryMapper.insertTranHistory(tranHistory);
        return i;
    }
}
