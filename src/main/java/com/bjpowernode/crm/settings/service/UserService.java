package com.bjpowernode.crm.settings.service;

import com.bjpowernode.crm.settings.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @Author:大润发杀鱼匠
 * @Date:2022/7/5 11:04 crm-project
 */


public interface UserService {
    User queryUserByLoginActAndPwd(Map<String, Object> map);

    List<User> queryAllUsers();
}
