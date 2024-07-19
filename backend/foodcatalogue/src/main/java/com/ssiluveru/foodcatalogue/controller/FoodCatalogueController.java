package com.ssiluveru.foodcatalogue.controller;


import com.ssiluveru.foodcatalogue.dto.FoodCataloguePage;
import com.ssiluveru.foodcatalogue.dto.FoodItemDTO;
import com.ssiluveru.foodcatalogue.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodcatalogue")
@CrossOrigin
public class FoodCatalogueController {

    @Autowired
    FoodCatalogueService foodCatalogueService;

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<FoodCataloguePage> getFoodItemsByRestaurant(@PathVariable Long id) {
        FoodCataloguePage foodCatalogueByRestaurant = foodCatalogueService.getFoodCatalogueByRestaurant(id);
        return new ResponseEntity<>(foodCatalogueByRestaurant, HttpStatus.OK);
    }

    @PostMapping("/item/add")
    public ResponseEntity<FoodItemDTO> addNewFoodItem(@RequestBody FoodItemDTO foodItemDTO) {
        return new ResponseEntity<>(foodCatalogueService.addNewFoodItem(foodItemDTO), HttpStatus.CREATED);
    }


}
