package main.UI;

import main.Utils.BusinessException;

/**
 * @Author Leevan
 * @Date： 2018/9/3 16:20
 */
public class WelcomeClass extends BaseClass {
    public void start(){
        println( getString( "info.welcome" ) );
        boolean flag = true;
        while (flag){
            println( getString( "info.login.reg" ) );
            println( getString( "info.select" ) );
            String select = input.nextLine();
            switch (select){
                case "1":
                    flag = false;
                    print( "登陆" );
                    break;
                case "2":
                    flag = false;
                    try{
                    new RegisterClass().register();
                    print( getString( "reg.success" ) );
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
