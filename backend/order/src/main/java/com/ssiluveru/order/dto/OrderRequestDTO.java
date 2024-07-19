package com.ssiluveru.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
    private Long userId;
    private List<FoodItemDTO> foodItems;
    private RestaurantDTO restaurant;
    private Float totalAmount;

}
