package con.caja.ideal.service.impl;

import con.caja.ideal.exceptions.ResourceNotFoundException;
import con.caja.ideal.models.OrderModels;
import con.caja.ideal.repository.IOrderRepository;
import con.caja.ideal.service.IOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderRepository repository;
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<List<OrderModels>> getAllOrder() {
        List<OrderModels> lista = repository.findAll().stream().toList();
        return  ResponseEntity.ok(lista);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<OrderModels> getOrder(Long id) {
        OrderModels order = repository.findById(id).orElseThrow(  () -> new ResourceNotFoundException("Not found order  " + id));
        return ResponseEntity.ok(order);
    }

    @Transactional
    @Override
    public ResponseEntity<OrderModels> saveOrder(OrderModels order) {
        OrderModels save = repository.save(order);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<OrderModels> updateOrder(OrderModels order, Long id) {
        OrderModels orderToUpdate = repository.findById(id).orElseThrow(  () -> new ResourceNotFoundException("Not found order  " + id));
        BeanUtils.copyProperties(order, orderToUpdate, "id");
        OrderModels update = repository.save(orderToUpdate);
        return ResponseEntity.ok(update);
    }

    @Override
    public ResponseEntity<Object> deleteOrder(Long id) {
        HashMap<String, Object> responde = new HashMap<>();
        OrderModels order = repository.findById(id).orElseThrow(  () -> new ResourceNotFoundException("Not found order  " + id));
        responde.put("message", "successfully removed ");
        return ResponseEntity.ok(responde);
    }
}
