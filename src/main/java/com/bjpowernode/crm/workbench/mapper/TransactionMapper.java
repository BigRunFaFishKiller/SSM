package com.bjpowernode.crm.workbench.mapper;

import com.bjpowernode.crm.workbench.domain.Transaction;
import com.bjpowernode.crm.workbench.domain.TransactionExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TransactionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran
     *
     * @mbggenerated Tue Jul 19 21:09:23 CST 2022
     */
    int countByExample(TransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran
     *
     * @mbggenerated Tue Jul 19 21:09:23 CST 2022
     */
    int deleteByExample(TransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran
     *
     * @mbggenerated Tue Jul 19 21:09:23 CST 2022
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran
     *
     * @mbggenerated Tue Jul 19 21:09:23 CST 2022
     */
    int insert(Transaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran
     *
     * @mbggenerated Tue Jul 19 21:09:23 CST 2022
     */
    int insertSelective(Transaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran
     *
     * @mbggenerated Tue Jul 19 21:09:23 CST 2022
     */
    List<Transaction> selectByExample(TransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran
     *
     * @mbggenerated Tue Jul 19 21:09:23 CST 2022
     */
    Transaction selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran
     *
     * @mbggenerated Tue Jul 19 21:09:23 CST 2022
     */
    int updateByExampleSelective(@Param("record") Transaction record, @Param("example") TransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran
     *
     * @mbggenerated Tue Jul 19 21:09:23 CST 2022
     */
    int updateByExample(@Param("record") Transaction record, @Param("example") TransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran
     *
     * @mbggenerated Tue Jul 19 21:09:23 CST 2022
     */
    int updateByPrimaryKeySelective(Transaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran
     *
     * @mbggenerated Tue Jul 19 21:09:23 CST 2022
     */
    int updateByPrimaryKey(Transaction record);


    /**
     * 根据条件分页查询交易
     * @param map
     * @return
     */
    List<Transaction> selectTranByConditionForPage(Map<String, Object> map);

    int selectTranCountsByConditionForPage(Map<String, Object> map);
}