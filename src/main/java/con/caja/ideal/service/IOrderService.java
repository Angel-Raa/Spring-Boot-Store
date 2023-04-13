package con.caja.ideal.service;

import con.caja.ideal.models.OrderModels;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderService {
    ResponseEntity<List<OrderModels>> getAllOrder();
    ResponseEntity<OrderModels> getOrder(Long id);
    ResponseEntity<OrderModels> saveOrder(OrderModels order);
    ResponseEntity<OrderModels> updateOrder(OrderModels order, Long id);
    ResponseEntity<Object> deleteOrder(Long id);

}
