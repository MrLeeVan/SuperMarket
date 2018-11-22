package main.UI;

import main.Bean.Costomer;
import main.MarketService.CostomerService;
import main.MarketService.Impl.CostomerServiceImpl;
import main.Utils.BusinessException;

/**
 * @Author Leevan
 * @Date： 2018/9/5 8:25
 */

/*登录实现类*/
public class LoginClass extends BaseClass {

    public void login()throws BusinessException{
        println( getString( "input.username" ) );
        String username = input.nextLine();
        println( getString( "input.password" ) );
        String password = input.nextLine();
        CostomerService costomerService = new CostomerServiceImpl() ;
        Costomer costomer = costomerService.login( username, password );

        if(costomer!=null){
            currUser = costomer;
        }
        else{
            throw new BusinessException( "login.error" );
        }
    }
}
