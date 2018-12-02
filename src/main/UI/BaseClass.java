package main.UI;

import main.Bean.Costomer;
import main.FreamWork.BeanFactory;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @Author Leevan
 * @Date： 2018/9/3 15:57
 */
public abstract class BaseClass {
    protected static Scanner input = new Scanner( System.in );
    protected static Costomer currUser;  //当前用户对象
    public BeanFactory beanFactory = null;
    private static ResourceBundle r =
            ResourceBundle.getBundle( "main.Res.r" );
    public static String getString(String key){
        return r.getString(key);
    }
    public static void print(String s){
        System.out.print(s);
    }
    public static void println(String s){
        System.out.println(s);
    }

    public BaseClass(){
       beanFactory = BeanFactory.init();
    }
}
