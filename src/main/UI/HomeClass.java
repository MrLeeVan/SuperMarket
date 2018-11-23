package main.UI;

import main.Bean.Clothes;
import main.Bean.Order;
import main.Bean.OrderItem;
import main.MarketService.ClothesService;
import main.MarketService.Impl.ClothesServiceImpl;
import main.MarketService.Impl.OrderServiceImpl;
import main.MarketService.OrderService;
import main.Utils.BusinessException;
import main.Utils.ConsoleTable;
import main.Utils.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/11/20 18:31
 */

/*登陆后的主界面*/
public class HomeClass extends BaseClass {

    private OrderService orderService = new OrderServiceImpl();
    private ClothesService clothesService =new ClothesServiceImpl();

    public void show() {
        SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd  hh:mm:ss" );;
        print( "welcome:" + currUser.getUsername() );
        println("\t\tLoginTime: "+df.format( new Date(  ) ) );
        menu();
    }
        private void menu(){
            boolean flag = true;
            while (flag) {
                println( getString( "home.function" ) );
                println( getString( "info.select" ) );
                String select = input.nextLine();
                switch (select) {
                    case "1":/*查询全部订单*/
                        findOrderList();
                        flag = false;
                        break;
                    case "2":/*查找订单*/
                        findOrderById();
                        flag = false;
                        break;
                    case "3":/*购买*/
                        try {
                            buyProducts();
                            flag = false;
                        } catch (BusinessException e) {
                            println( e.getMessage() );
                        }
                        break;
                    case "4":/*显示商品*/
                        showProducts();
                        menu();
                        break;

                    case "0":/*退出*/
                        flag = false;
                        println( getString( "info.exit" ) );
                        System.exit( 0 );
                        break;
                    default:
                        println( getString( "input.error" ) );

                }

            }
        }

    private void findOrderList(){
        List<Order> list = orderService.list();
        for (Order o :list){
            showOrder(o);
        }
        menu();
    }
    private void showOrder(Order o){
        print( getString( "product.order.oid" )+o.getOrderId() );
        print( "\t\t" +getString( "product.order.CreateDate" )+o.getCreateDate() );
        println( "\t\t"+getString("product.order.sum")+o.getSum() );
        ConsoleTable table = new ConsoleTable( 9 ,true);
        table.appendRow();
        table.appendColum( "itemId" )
                .appendColum( "brand" )
                .appendColum( "style" )
                .appendColum( "color" )
                .appendColum( "size" )
                .appendColum( "ShoppingNum" )
                .appendColum( "price" )
                .appendColum( "description" )
                .appendColum( "sum" );
        for (OrderItem item :o.getOrderItemList()){
            table.appendRow();
            table.appendColum( item.getItemId() )
                    .appendColum( item.getClothes().getBrand() )
                    .appendColum( item.getClothes().getStyle() )
                    .appendColum( item.getClothes().getColor() )
                    .appendColum( item.getClothes().getSize() )
                    .appendColum( item.getClothes().getDescription() )
                    .appendColum( item.getShoppingNum())
                    .appendColum( item.getClothes().getPrice() )
                    .appendColum( item.getSum() );

        }

        System.out.println( table.toString() );
    }

    private void findOrderById(){
        println( getString( "product.input.oid" ) );
        String oid = input.nextLine();
        Order order = orderService.findById( Integer.parseInt( oid ) );
        if(order != null ){
            showOrder( order );
        }
        else{
         println( getString( "product.order.error" ));
        }
    }
/*购买商品的过程*/
    private void buyProducts() throws BusinessException {
        //购买商品，生成订单
        Order order =new Order(  );
        int count =1 ;
        float sum = 0.0f;
        boolean flag = true;
        while (flag){
            print( getString( "product.input.id" ) );
            String id = input.nextLine();
            print( getString( "product.input.shoppingNum" ) );
            String shoppingNum =input.nextLine();
            OrderItem orderItem =new OrderItem();
            Clothes clothes = clothesService.findById(id);


            /***************************/
            orderItem.setClothes( clothes );
            int num = Integer.parseInt( shoppingNum );
            if(num > clothes.getNum()){
                 throw new BusinessException( "product.num.error" );
            }
            //一条订单明细
            clothes.setNum( clothes.getNum() - num ); //减库存！
            orderItem.setClothes( clothes );
            orderItem.setShoppingNum( num );
            orderItem.setSum( clothes.getPrice()*num );
            sum += orderItem.getSum();
            orderItem.setItemId( count++ );
            order.getOrderItemList().add(orderItem);

            println( getString( "product.buy.continue" ) );
            String buy = input.nextLine();
            switch(buy){
                case "1":
                    flag = true ;
                    break;
                case "2":
                    flag = false ;
                    break;
                default:
                    flag = false;
                    break;
            }

        }
         //总订单明细
        order.setCreateDate( DateUtils.toDate( new Date(  ) ) );
        order.setUsrId( currUser.getUsrId() );
        order.setSum( sum );
        order.setOrderId( orderService.list().size() +1 );
        orderService.buyProduct( order );
        clothesService.update();
        menu();


    }


/*控制台上展示商品列表 :*/

    private void showProducts(){
        List<Clothes> list = clothesService.list();
        ConsoleTable t = new ConsoleTable( 8, true );
        t.appendRow();
        t.appendColum( "id" )
                .appendColum( "brand" )
                .appendColum( "style" )
                .appendColum( "color" )
                .appendColum( "size" )
                .appendColum( "num" )
                .appendColum( "price" )
                .appendColum( "description" );
        for(Clothes c: list){
            t.appendRow();
            t.appendColum( c.getId() )
                    .appendColum( c.getBrand() )
                    .appendColum( c.getStyle() )
                    .appendColum( c.getColor() )
                    .appendColum( c.getSize() )
                    .appendColum( c.getNum() )
                    .appendColum( c.getPrice() )
                    .appendColum( c.getDescription() );

        }
        println( t.toString() );


    }
}
