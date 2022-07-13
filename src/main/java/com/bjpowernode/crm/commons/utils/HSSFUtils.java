package com.bjpowernode.crm.commons.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;

/**
 * @Author:大润发杀鱼匠
 * @Date:2022/7/13 18:44 crm-project
 *
 * Excel工具类
 */


public class HSSFUtils {

    /**
     * 从指定HSSFCell对象中获取值
     * @return
     */
    public static String getCellValueForStr(HSSFCell cell) {

        String ret = null;
        if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
            ret = cell.getStringCellValue();
        } else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
            ret = cell.getBooleanCellValue() + "";
        } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            ret = cell.getNumericCellValue() + "";
        } else if (cell.getCellType() == HSSFCell.CELL_TYPE_FORMULA) {
            ret = cell.getCellFormula() + "";
        } else {
            ret = "";
        }
        return ret;
    }
}
