package main.MarketService.Impl;

import main.Bean.Clothes;
import main.MarketService.ClothesService;
import main.Utils.BusinessException;
import main.Utils.ClothesIO;
import main.Utils.ProductsXmlUtils;

import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/11/20 19:00
 */
/*商品，衣服*/
public class ClothesServiceImpl implements ClothesService {
    private ClothesIO clothesIO = new ClothesIO();
    @Override
    public List<Clothes> list() throws BusinessException {

        return clothesIO.clothesList();
    }

    @Override
    public Clothes findById(int cid) throws BusinessException {
        return clothesIO.findById( cid );

    }
}
