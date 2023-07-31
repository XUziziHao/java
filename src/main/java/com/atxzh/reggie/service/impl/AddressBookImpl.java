package com.atxzh.reggie.service.impl;


import com.atxzh.reggie.entity.AddressBook;
import com.atxzh.reggie.mapper.AddressBookMapper;
import com.atxzh.reggie.service.AddressBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AddressBookImpl extends ServiceImpl<AddressBookMapper, AddressBook>implements AddressBookService {
}
