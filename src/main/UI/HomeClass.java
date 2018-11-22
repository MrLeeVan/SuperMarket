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

import javax.security.auth.login.AccountException;
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

    public void show(){
       showProducts();
       println( "welcome:" +currUser.getUsername() );
       boolean flag = true;
       while(flag){
           println( getString( "home.function" ) );
           println( getString( "info.select" ) );
           String select = input.nextLine();
           switch (select){
               case "1":/*查询全部订单*/
                   findList();
                   flag = false;
                   break;
               case "2":/*查找订单*/
                   findOrderById();
                   flag = false;
                   break;
               case "3":/*购买*/
                   buyProducts();
                   flag = false;
                   break;
               case "0":/*退出*/
                   flag = false;
                   System.exit( 0 );
                   break;
               default:
                   println( getString( "input.error" ) );

           }

       }
    }

    private void findList(){}

    private void findOrderById(){}

    private void buyProducts() throws BusinessException {
        //购买商品，生成订单
        Order order =new Order(  );
        int count =1 ;
        float sum = 0.0f;
        boolean flag = true;
        while (flag){
            print( getString( "product.input.id" ) );
            String id = input.nextLine();
            println( getString( "product.input.shoppingNum" ) );
            String shoppingNum =input.nextLine();
            OrderItem orderItem =new OrderItem(  );
            Clothes clothes = clothesService.findById( Integer.parseInt( id ) );


            /***************************/
            orderItem.setClothes( clothes );
            int num = Integer.parseInt( shoppingNum );
            if(num > clothes.getNum()){
                 throw new BusinessException( "product.num.error" );
            }
            //一条订单明细
            orderItem.setClothes( clothes );
            orderItem.setShoppingNum( num );
            orderItem.setSum( clothes.getPrice()*num );
            sum += orderItem.getSum();
            orderItem.setItemId( count++ );
            order.getOrderItemList().add(orderItem);

        }
         //总订单明细
        order.setCreateDate( DateUtils.toDate( new Date(  ) ) );
        order.setUsrId( currUser.getUsrId() );
        order.setSum( sum );
        order.setOrderId( orderService.list().size() +1 );


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
