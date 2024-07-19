package com.ssiluveru.order.entity;

import com.ssiluveru.order.dto.FoodItemDTO;
import com.ssiluveru.order.dto.RestaurantDTO;
import com.ssiluveru.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long orderId;
    private List<FoodItemDTO> foodItems;
    private RestaurantDTO restaurant;
    private UserDTO user;
    private Float totalAmount;

}
