package com.lkf.springcloud.dao;


import com.lkf.springcloud.bo.PaymentBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    /**
     * 保存
     *
     * @param paymentBO
     * @return
     */
    int create(PaymentBO paymentBO);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    PaymentBO queryPaymentById(@Param("id") Long id);
}
