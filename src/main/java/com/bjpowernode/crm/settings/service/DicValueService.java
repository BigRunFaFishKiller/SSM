package com.bjpowernode.crm.settings.service;

import com.bjpowernode.crm.settings.domain.DicValue;

import java.util.List;

/**
 * @Author:大润发杀鱼匠
 * @Date:2022/7/15 16:32 crm-project
 */


public interface DicValueService {

    List<DicValue> queryDicValueByTypeCode(String typeCode);

}
