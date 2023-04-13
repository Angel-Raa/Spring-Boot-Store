package con.caja.ideal.service.impl;

import con.caja.ideal.exceptions.ResourceNotFoundException;
import con.caja.ideal.models.ProductModels;
import con.caja.ideal.repository.IProductRepository;
import con.caja.ideal.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository repository;


    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<ProductModels>> getAllProducts() {
        List<ProductModels> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<ProductModels> getProduct(Long id) {
        ProductModels product = repository.findById(id).orElseThrow(( ) -> new ResourceNotFoundException("Not found product " + id) );
        return ResponseEntity.ok(product);
    }



    @Override
    @Transactional
    public ResponseEntity<ProductModels> saveProduct(ProductModels product) {
        ProductModels save = repository.save(product);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @Override
    @Transactional
    public ResponseEntity<ProductModels> updateProduct( ProductModels product, Long id) {
        ProductModels producto = repository.findById(id).orElseThrow(( ) -> new ResourceNotFoundException("this id already exists " + id) );
        BeanUtils.copyProperties(product, producto, "id");
        ProductModels updatedProduct = repository.save(producto);
        return ResponseEntity.ok(updatedProduct);
    }

    @Override
    @Transactional
    public ResponseEntity<ProductModels> deleteProduct (Long id) {
        ProductModels product = repository.findById(id).orElseThrow(( ) -> new ResourceNotFoundException("Not found product " + id) );
        repository.delete(product);
        return ResponseEntity.badRequest().body(product);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<ProductModels> getProductName(String name) {
        ProductModels nameProduct = repository.findByName(name).orElseThrow( ( ) -> new ResourceNotFoundException("Not found product ".concat(name)));
        return ResponseEntity.ok(nameProduct);
    }


}
