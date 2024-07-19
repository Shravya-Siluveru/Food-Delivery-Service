package com.ssiluveru.order.controller;

import com.ssiluveru.order.dto.OrderDTO;
import com.ssiluveru.order.dto.OrderRequestDTO;
import com.ssiluveru.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderRequestDTO orderRequest) {
        OrderDTO orderDTO = orderService.saveOrder(orderRequest);
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }

}
