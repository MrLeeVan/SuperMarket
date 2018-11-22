package main.UI;

import main.Bean.Costomer;
import main.MarketService.CostomerService;
import main.MarketService.Impl.CostomerServiceImpl;
import main.Utils.BusinessException;

/**
 * @Author Leevan
 * @Date： 2018/9/3 16:53
 */
/*注册实现类*/
public class RegisterClass extends BaseClass {

    public void register() throws BusinessException {
        println( getString( "input.username" ) );
        String username = input.nextLine();
        println( getString( "input.password" ) );
        String password = input.nextLine();
        Costomer costomer = new Costomer( username, password );
        CostomerService costomerService = new CostomerServiceImpl();
        costomerService.register( costomer );
    }
}
