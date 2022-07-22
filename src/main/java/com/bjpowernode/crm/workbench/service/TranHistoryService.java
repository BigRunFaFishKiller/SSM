package com.bjpowernode.crm.workbench.service;

import com.bjpowernode.crm.workbench.domain.TranHistory;

import java.util.List;

/**
 * @Author:大润发杀鱼匠
 * @Date:2022/7/22 12:37 crm-project
 */


public interface TranHistoryService {

    List<TranHistory> queryTranHistoryForDetailByTranId(String tranId);

}
