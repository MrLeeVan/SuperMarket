package main.MarketService.Impl;

import main.Bean.Costomer;
import main.MarketService.CostomerService;
import main.Utils.BusinessException;
import main.Utils.CostomerIO;
import main.Utils.EmptyUtils;

/**
 * @Author Leevan
 * @Date： 2018/9/3 17:08
 */
public class CostomerServiceImpl implements CostomerService {
    @Override
    public Costomer login(String username, String password) throws BusinessException {
        if(EmptyUtils.isEmpty(username)){
            throw new BusinessException( "username.notnull" );
        }
        if(EmptyUtils.isEmpty( password )){
            throw new BusinessException( "password.notnull" );
        }
        CostomerIO costomerIO = new CostomerIO();
        Costomer costomer = costomerIO.findByUsernameAndPassword( username, password );
        return costomer;
    }

    @Override
    public Costomer register(Costomer costomer) throws BusinessException {

        CostomerIO costomerIO = new CostomerIO();
        costomerIO.add( costomer );
        costomerIO.writeCostomers();
        return costomer;


}
}
