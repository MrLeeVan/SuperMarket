package main.UI;

import main.Utils.BusinessException;
import main.Utils.CostomerIO;

/**
 * @Author Leevan
 * @Date： 2018/9/3 16:20
 */
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
                        print( getString( "login.success" ) );
                    }catch (BusinessException e){
                        print( getString( e.getMessage() ) );
                    }
                    break;
        //注册
                case "2":
                    try{
                    new RegisterClass().register();
                    print( getString( "reg.success" ) );
                    flag = false;
                    }
                    catch (BusinessException e){
                          print( getString( "reg.error" ) );
                    }
                    break;
                default:
                    println( getString( "input.error" ) );
                    break;

            }

        }
    }
}
