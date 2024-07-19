package com.ssiluveru.order.service;

import com.ssiluveru.order.dto.OrderDTO;
import com.ssiluveru.order.dto.OrderRequestDTO;
import com.ssiluveru.order.dto.UserDTO;
import com.ssiluveru.order.entity.Order;
import com.ssiluveru.order.mapper.OrderMapper;
import com.ssiluveru.order.respository.OrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRespository orderRespository;

    @Autowired
    private SequenceGenerator sequenceGenerator;

    @Autowired
    private RestTemplate restTemplate;

    public OrderDTO saveOrder(OrderRequestDTO request) {
        Long newOrderId = sequenceGenerator.generateNextOrderId();

        UserDTO userDTO = fetchUserDetails(request.getUserId());
        Order order = new Order(newOrderId, request.getFoodItems(), request.getRestaurant(),
                userDTO, request.getTotalAmount());
        Order savedOrder = orderRespository.save(order);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(savedOrder);
    }

    private UserDTO fetchUserDetails(Long userId) {
        return restTemplate.getForObject("http://USER-INFO-SERVICE/user/" + userId,
                UserDTO.class);
    }

}
