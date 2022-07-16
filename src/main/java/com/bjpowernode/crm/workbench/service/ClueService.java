package com.bjpowernode.crm.workbench.service;

import com.bjpowernode.crm.workbench.domain.Clue;

import java.util.List;
import java.util.Map;

/**
 * @Author:大润发杀鱼匠
 * @Date:2022/7/15 17:34 crm-project
 */


public interface ClueService {

    int saveCreateClue(Clue clue);

    List<Clue> queryClueForPage(Map<String, Object> map);

    int countClueByCondition(Map<String, Object> map);

    int deleteClueByIds(String[] ids);

    Clue queryClueForDetailById(String id);

}
