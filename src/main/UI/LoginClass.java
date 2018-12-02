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
    private CostomerService costomerService;
    public LoginClass(){
       costomerService = (CostomerService) beanFactory.getBaen( "costomerService" );
    }

    public String LoginDate;
    public String getLoginDate() {
        return LoginDate;
    }

    public void setLoginDate(String loginDate) {
        LoginDate = loginDate;
    }

    public void login()throws BusinessException{
        print( getString( "input.username" ) );
        String username = input.nextLine();
        print( getString( "input.password" ) );
        String password = input.nextLine();
//        CostomerService costomerService = new CostomerServiceImpl() ;   优化后删除
        Costomer costomer = costomerService.login( username, password );


        if(costomer!=null){
            currUser = costomer;
        }
        else{
            throw new BusinessException( "login.error" );
        }
    }
}
