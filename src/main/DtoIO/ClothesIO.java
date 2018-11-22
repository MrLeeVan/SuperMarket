package main.DtoIO;

import main.Bean.Clothes;
import main.Utils.BusinessException;
import main.Utils.ProductsXmlUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/11/22 12:08
 */
public class ClothesIO {
    private static List<Clothes> clothesList = new ArrayList<>(  );
    public Clothes findById(int cid) throws BusinessException {
        for(Clothes c: clothesList()){
            if(c.getId().equals( cid )){
                return c ;
            }
        }
        return  null;
    }
    public List<Clothes> clothesList() throws BusinessException{
        if (clothesList.size() == 0){
            clothesList = ProductsXmlUtils.parserProductFormXml();
        }
        return clothesList;
    }


    /*更新XML文件*/
    public void update() throws BusinessException{
        ProductsXmlUtils.writeProductToXml( clothesList() );
    }
}
