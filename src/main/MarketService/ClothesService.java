package main.MarketService;

import main.Bean.Clothes;
import main.Utils.BusinessException;

import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/11/20 18:57
 */
public interface ClothesService {
     List<Clothes> list() throws BusinessException;
     Clothes findById(String cid) throws BusinessException;
     void update() throws BusinessException;
}
