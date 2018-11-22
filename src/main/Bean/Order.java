package main.Bean;

import main.Util.OrderStatusType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/8/17 11:47
 */

//总订单：订单总计（和orderItem 一对多的关系）
public class Order implements Serializable {
    private int orderId;
    private List<OrderItem> orderItemList=new ArrayList<>();
    private String createDate;
    private float sum; //总金额
    private OrderStatusType status=OrderStatusType.UNPAID;//支付状态
    private int usrId;

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public OrderStatusType getStatus() {
        return status;
    }

    public void setStatus(OrderStatusType status) {
        this.status = status;
    }
//默认构造方法

public Order(){

}
    public Order(int orderId, List<OrderItem> orderItemList, String createDate, float sum, OrderStatusType status) {
        this.orderId = orderId;
        this.orderItemList = orderItemList;
        this.createDate = createDate;
        this.sum = sum;
        this.status = status;
    }
}
