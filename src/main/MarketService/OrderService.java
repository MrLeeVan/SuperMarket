package main.MarketService;

import main.Bean.Order;
import main.Utils.BusinessException;

import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/11/21 19:23
 */
public interface OrderService {
     void buyProduct(Order o) throws BusinessException;
    List<Order> list() throws BusinessException;
    Order findById(int orderId) throws  BusinessException;
}
