package com.ssiluveru.order.respository;

import com.ssiluveru.order.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRespository extends MongoRepository<Order, Long> {
}
