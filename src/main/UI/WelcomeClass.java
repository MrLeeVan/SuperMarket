package main.UI;

import main.Utils.BusinessException;
import main.DtoIO.CostomerIO;

/**
 * @Author Leevan
 * @Date： 2018/9/3 16:20
 */
/*主逻辑类，所有程序类的开端*/
public class WelcomeClass extends BaseClass {
    public void start(){
        println( getString( "info.welcome" ) );
        CostomerIO costomerIO = new CostomerIO();
        costomerIO.readCostomers();
        boolean flag = true;
        while (flag){
            println( getString( "info.login.reg" ) );
            println( getString( "info.select" ) );
            String select = input.nextLine();
            switch (select){
        //登陆
                case "1":
                    try{
                        new LoginClass().login();
                        println( getString( "login.success" ) );
                        flag = false;
                    }catch (BusinessException e){
                        println( getString( e.getMessage() ) );
                    }
                    break;
        //注册
                case "2":
                    try{
                    new RegisterClass().register();
                    println( getString( "reg.success" ) );
                    flag = true;
                    }
                    catch (BusinessException e){
                          println( getString( "reg.error" ) );
                    }
                    break;
                default:
                    println( getString( "input.error" ) );
                    break;

            }

        }
        HomeClass homeClass = new HomeClass();
        homeClass.show();

    }
}
