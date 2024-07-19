package com.ssiluveru.foodcatalogue.service;

import com.ssiluveru.foodcatalogue.dto.FoodCataloguePage;
import com.ssiluveru.foodcatalogue.dto.FoodItemDTO;
import com.ssiluveru.foodcatalogue.dto.RestaurantDTO;
import com.ssiluveru.foodcatalogue.entity.FoodItem;
import com.ssiluveru.foodcatalogue.mapper.FoodItemMapper;
import com.ssiluveru.foodcatalogue.repository.FoodItemRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodCatalogueService {

    @Autowired
    private FoodItemRespository foodItemRespository;

    @Autowired
    private RestTemplate restTemplate;

    public FoodItemDTO addNewFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItem = foodItemRespository.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItem);
    }

    public FoodCataloguePage getFoodCatalogueByRestaurant(Long restaurantId) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        // get restaurant details
        RestaurantDTO restaurantDetails = getRestaurantDetails(restaurantId);
        foodCataloguePage.setRestaurant(restaurantDetails);
        // get food items for that  restaurant
        List<FoodItemDTO> foodItems = getFoodItems(restaurantId);
        foodCataloguePage.setFoodItems(foodItems);
        return foodCataloguePage;
    }

    private List<FoodItemDTO> getFoodItems(Long restaurantId) {
        return foodItemRespository.getByRestaurantId(restaurantId).stream()
                .map(FoodItemMapper.INSTANCE::mapFoodItemToFoodItemDTO).collect(Collectors.toList());
    }

    private RestaurantDTO getRestaurantDetails(Long restaurantId) {
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/" + restaurantId,
                RestaurantDTO.class);

    }

}
