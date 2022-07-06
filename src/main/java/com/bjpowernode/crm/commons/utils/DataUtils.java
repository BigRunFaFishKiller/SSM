package com.bjpowernode.crm.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:大润发杀鱼匠
 * @Date:2022/7/5 15:43 crm-project
 *
 * 对Data类处理的工具类
 */


public class DataUtils {

    /**
     * 对Date对象格式化
     * @param date
     * @param format 传入的格式
     * @return
     */
    public static String formateDateTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

}
