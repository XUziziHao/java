package com.atxzh.reggie.service.impl;


import com.atxzh.reggie.entity.User;
import com.atxzh.reggie.mapper.UserMapper;
import com.atxzh.reggie.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserImpl extends ServiceImpl<UserMapper, User>implements UserService {
}
