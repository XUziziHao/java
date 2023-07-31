package com.atxzh.reggie.dto;

import com.atxzh.reggie.entity.Setmeal;
import com.atxzh.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
