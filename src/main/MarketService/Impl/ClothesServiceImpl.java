package main.MarketService.Impl;

import main.Bean.Clothes;
import main.MarketService.ClothesService;
import main.Utils.BusinessException;
import main.Utils.ProductsXmlUtils;

import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/11/20 19:00
 */
public class ClothesServiceImpl implements ClothesService {
    @Override
    public List<Clothes> list() throws BusinessException {
        List<Clothes> clothes = ProductsXmlUtils.parserProductFormXml();
        return clothes;
    }
}
