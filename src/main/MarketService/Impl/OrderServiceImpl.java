package main.MarketService.Impl;

import main.Bean.Order;
import main.MarketService.OrderService;
import main.Utils.BusinessException;

import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/11/21 19:27
 */
/*订单*/
public class OrderServiceImpl implements OrderService {
    @Override
    public void buyProduct(Order o) throws BusinessException {

    }

    @Override
    public List<Order> list() throws BusinessException {
        return null;
    }

    @Override
    public Order findById(int orderId) throws BusinessException {
        return null;
    }
}
