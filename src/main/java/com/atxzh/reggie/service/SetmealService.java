package com.atxzh.reggie.service;

import com.atxzh.reggie.dto.SetmealDto;
import com.atxzh.reggie.entity.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，同时删除套餐和菜品关联的数据
     * @param ids
     */
    public void removeWithDish(List<Long> ids);
}
