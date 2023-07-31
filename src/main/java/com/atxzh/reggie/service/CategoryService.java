package com.atxzh.reggie.service;

import com.atxzh.reggie.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CategoryService extends IService<Category> {
    public void remove(Long ids);
}
