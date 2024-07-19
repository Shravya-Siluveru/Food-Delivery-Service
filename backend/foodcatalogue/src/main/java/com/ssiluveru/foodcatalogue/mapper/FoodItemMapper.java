package com.ssiluveru.foodcatalogue.mapper;

import com.ssiluveru.foodcatalogue.dto.FoodItemDTO;
import com.ssiluveru.foodcatalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {
    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);
    FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);
}
