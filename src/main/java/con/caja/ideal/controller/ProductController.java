package con.caja.ideal.controller;


import con.caja.ideal.models.ProductModels;
import con.caja.ideal.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/v1")
public class ProductController {
    @Autowired
    private IProductService service;

    @GetMapping("/product")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProductModels>> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/type/{name}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ProductModels> getProductByName(@PathVariable(value = "name") String name) {
        return service.getProductName(name);
    }

    @GetMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductModels> getProducts(@PathVariable Long id) {
        return service.getProduct(id);
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductModels> postProducts(@Valid @RequestBody ProductModels productModel){
        return service.saveProduct(productModel);
    }

    @PutMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductModels> putProduct(@Valid @RequestBody ProductModels productModel, @PathVariable Long id){
        return service.updateProduct(productModel, id);
    }

    @DeleteMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductModels> deleteProduct(@PathVariable Long id){
        return service.deleteProduct(id);
    }



}
