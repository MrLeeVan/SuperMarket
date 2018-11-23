package main.MarketService.Impl;

import main.Bean.Order;
import main.DtoIO.OrderIO;
import main.MarketService.OrderService;
import main.Utils.BusinessException;

import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/11/21 19:27
 */
/*订单*/
public class OrderServiceImpl implements OrderService {
    private OrderIO orderIO = new OrderIO();

    @Override
    public void buyProduct(Order o) throws BusinessException {
         orderIO.add( o );
    }

    @Override
    public List<Order> list() throws BusinessException {
        return orderIO.list();
    }

    @Override
    public Order findById(int orderId) throws BusinessException {
        return orderIO.findByOrderId( orderId );
    }
}
