package com.ssiluveru.foodcatalogue.repository;

import com.ssiluveru.foodcatalogue.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRespository extends JpaRepository<FoodItem, Long> {
    List<FoodItem> getByRestaurantId(Long restaurantId);
}
