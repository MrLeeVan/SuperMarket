package main.DtoIO;

import main.Bean.Order;
import main.Util.BusinessException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/11/21 19:00
 */
public class OrderIO {
    private static List<Order> orders= new ArrayList<>();
    private static final String ORDER_FILE ="oder.obj";
    public void add(Order order) throws BusinessException {
        orders.add( order );

    }

    public List<Order> list() throws BusinessException{
     return null;
    }

    public Order findByOrderId(int orderId) throws BusinessException{
        Order order = null;
        int oid ;
        for(Order o: orders){
            oid = o.getOrderId();
            if (oid == orderId){
                order = o;
                break;
            }
        }
        return order;
    }

    public boolean readOrder(){
        try{
            ObjectInputStream in = new ObjectInputStream( new FileInputStream( ORDER_FILE ) );
            orders = ((List<Order>) in.readObject());
            return  true;
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean writeOrder(){
        try{
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream( ORDER_FILE ) );
            out.writeObject( orders );
            out.close();
            return true;
        }catch (IOException e){
            e.printStackTrace();
        }
        return false;

    }
}
