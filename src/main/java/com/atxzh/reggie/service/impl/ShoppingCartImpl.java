package com.atxzh.reggie.service.impl;


import com.atxzh.reggie.entity.ShoppingCart;
import com.atxzh.reggie.mapper.ShoppingCartMapper;
import com.atxzh.reggie.service.ShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
