package con.caja.ideal.controller;

import con.caja.ideal.models.OrderModels;
import con.caja.ideal.service.IOrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/v1")
public class OrderControlles {
    @Autowired
    private IOrderService service;

    @GetMapping("/order")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<OrderModels>> getAllOrder() {
        return service.getAllOrder();
    }

    @GetMapping("/order/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<OrderModels> getOrder(@PathVariable Long id) {
        return service.getOrder(id);
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OrderModels> postOrder(@Valid @RequestBody OrderModels order) {
        return service.saveOrder(order);
    }

    @PutMapping("/order/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<OrderModels> updateOrder(@Valid @RequestBody OrderModels order, @PathVariable Long id) {
        return  service.updateOrder(order, id);
    }

    @DeleteMapping("/order/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> deleteOrder(@PathVariable Long id){
        return service.deleteOrder(id);
    }



}
