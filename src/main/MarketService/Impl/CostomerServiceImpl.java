package main.MarketService.Impl;

import main.Bean.Costomer;
import main.MarketService.CostomerService;
import main.Utils.BusinessException;
import main.Utils.CostomerIO;

/**
 * @Author Leevan
 * @Date： 2018/9/3 17:08
 */
public class CostomerServiceImpl implements CostomerService {
    @Override
    public Costomer register(Costomer costomer) throws BusinessException {
        CostomerIO costomerIO = new CostomerIO();
        costomerIO.add( costomer );
        costomerIO.writeCostomers();
        return costomer;
}
}
