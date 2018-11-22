package main.MarketService;

import main.Bean.Costomer;
import main.Util.BusinessException;
import org.springframework.stereotype.Service;

/**
 * @Author Leevan
 * @Date： 2018/9/3 17:06
 */
@Service
public interface CostomerService {
     Costomer register(Costomer costomer)throws BusinessException;
     Costomer login(String username, String password)throws BusinessException;
}
