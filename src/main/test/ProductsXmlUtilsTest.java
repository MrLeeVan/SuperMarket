package main.test;
import main.Bean.Clothes;
import main.Util.ProductsXmlUtils;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/11/20 14:34
 */
public class ProductsXmlUtilsTest{
    @Test
    public void test(){
        List<Clothes> clothes = ProductsXmlUtils.parserProductFormXml();
        System.out.println( Arrays.toString(clothes.toArray()));
    }
}
