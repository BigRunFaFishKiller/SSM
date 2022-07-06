package com.bjpowernode.crm.commons.utils;

import java.util.UUID;

/**
 * @Author:大润发杀鱼匠
 * @Date:2022/7/6 11:03 crm-project
 */


public class UUIDUtils {

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
