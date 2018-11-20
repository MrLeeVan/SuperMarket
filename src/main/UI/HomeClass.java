package main.UI;

import main.Bean.Clothes;
import main.MarketService.ClothesService;
import main.MarketService.Impl.ClothesServiceImpl;
import main.Utils.ConsoleTable;

import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/11/20 18:31
 */
public class HomeClass extends BaseClass {
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

    private void buyProducts(){}




    private void showProducts(){
        ClothesService clothesService = new ClothesServiceImpl();
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
