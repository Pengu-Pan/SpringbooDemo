package example.service.impl;


import example.dao.mapper.OrderMapper;
import example.dao.po.TbOrderPo;
import example.dao.po.TbUserPo;
import example.pojo.Order;
import example.pojo.User;
import example.service.api.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;


    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Order queryOrderById(Long orderId){
        // 1.查询订单 todo 优化异常
        TbOrderPo orderPo = orderMapper.findById(orderId);
        // 2.利用RestTemplate发起http请求，查询用户
        // 2.1.url路径
        String url = "http://userservice/user/" + orderPo.getUserId();
        // 2.2.发送http请求，实现远程调用
        User user = restTemplate.getForObject(url, User.class);
        // 3.封装user到Order
        orderPo.setUser(user);
        // 4.赋值,服务层不要返回Po类型
        Order order = new Order();
        BeanUtils.copyProperties(orderPo,order);

        return order;
    }


}
