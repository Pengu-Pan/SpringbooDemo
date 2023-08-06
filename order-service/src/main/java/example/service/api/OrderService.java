package example.service.api;

import example.pojo.Order;

public interface OrderService {
    Order queryOrderById(Long id);
}
