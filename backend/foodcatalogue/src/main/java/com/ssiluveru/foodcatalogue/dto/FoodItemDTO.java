package com.ssiluveru.foodcatalogue.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDTO {
    private Long id;
    private String name;
    private String description;
    private Boolean isVeg;
    private Float price;
    private Long restaurantId;
    private Integer quantity;

}
