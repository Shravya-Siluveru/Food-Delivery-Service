package com.ssiluveru.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDTO {
    private Long id;
    private String name;
    private String description;
    private Boolean isVeg;
    private Float price;
    private Long restaurantId;
    private Integer quantity;
}
