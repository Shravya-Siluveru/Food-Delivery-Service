package com.ssiluveru.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long orderId;
    private UserDTO user;
    private List<FoodItemDTO> foodItems;
    private RestaurantDTO restaurant;
    private Float totalAmount;

}
