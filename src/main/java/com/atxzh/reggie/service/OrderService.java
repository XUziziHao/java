package com.atxzh.reggie.service;

import com.atxzh.reggie.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

public interface OrderService extends IService<Orders> {
    /**
     * 用户下单
     * @param orders
     */

    public void submit(Orders orders);
}
