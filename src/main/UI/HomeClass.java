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
    }
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
