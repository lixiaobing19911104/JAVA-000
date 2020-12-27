package demo.rpc;


import com.lxb.demo.exception.RpcException;
import demo.Order;
import demo.service.OrderService;

/**
 * @author lw
 */
public class OrderServiceImpl implements OrderService {

    @Override
    public Order findById(Integer id) {
        return new Order(1, "RPC", 1);
    }

    @Override
    public Order findError() {
        throw new RpcException("Custom exception");
    }
}
