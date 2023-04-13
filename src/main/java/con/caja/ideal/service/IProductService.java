package con.caja.ideal.service;


import con.caja.ideal.models.ProductModels;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IProductService {
    ResponseEntity<List<ProductModels>> getAllProducts();
    ResponseEntity<ProductModels> getProduct(Long id);
    ResponseEntity<ProductModels> saveProduct(ProductModels product);
    ResponseEntity<ProductModels> updateProduct(ProductModels product, Long id);

    ResponseEntity<ProductModels> deleteProduct(Long id);
    ResponseEntity<ProductModels> getProductName(String name);
}
