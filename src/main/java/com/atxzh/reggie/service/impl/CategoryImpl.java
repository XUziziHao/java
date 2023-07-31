package com.atxzh.reggie.service.impl;

import com.atxzh.reggie.common.CustomException;
import com.atxzh.reggie.entity.Category;
import com.atxzh.reggie.entity.Dish;
import com.atxzh.reggie.entity.Setmeal;
import com.atxzh.reggie.mapper.CategoryMapper;
import com.atxzh.reggie.service.CategoryService;
import com.atxzh.reggie.service.DishService;
import com.atxzh.reggie.service.SetmealService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private SetmealService setmealService;
    @Autowired
    private DishService dishService;
    /**
     * 根据id删除分类，删除之前需要进行判断
     * @param ids
     */
    @Override
    public void remove(Long ids) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();


        //添加查询条件，根据分类id进行查询
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,ids);
        int count1 = dishService.count(dishLambdaQueryWrapper);
        //查询当前分类是否关联菜品，如果关联抛出异常
        if(count1>0){
            //已经关联菜品，抛出一个业务异常
            throw new CustomException("当前分类下关联了菜品，不能删除");
        }

        //查询当前分类是否关联套餐，如果关联抛出异常
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,ids);
        int count2 = setmealService.count(setmealLambdaQueryWrapper);
        if (count2>0){
            //已关联套餐，抛出一个业务异常

            throw new CustomException("当前分类下关联了菜品，不能删除");
        }

        //正常删除分类
        super.removeById(ids);

    }
}
