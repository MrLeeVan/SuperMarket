package main.Utils;

/**
 * @Author Leevan
 * @Date： 2018/9/3 16:55
 */
public class BusinessException extends RuntimeException {
    public BusinessException(){
        super();
    }
    public BusinessException(String errorMessage){
        super(errorMessage);
    }
}
