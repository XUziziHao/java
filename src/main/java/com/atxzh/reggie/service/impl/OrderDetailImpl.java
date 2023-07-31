package com.atxzh.reggie.service.impl;

import com.atxzh.reggie.entity.OrderDetail;
import com.atxzh.reggie.mapper.OrderDetailMapper;
import com.atxzh.reggie.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>implements OrderDetailService {
}
