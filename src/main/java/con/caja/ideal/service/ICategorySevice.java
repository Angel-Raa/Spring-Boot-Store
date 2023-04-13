package con.caja.ideal.service;

import con.caja.ideal.models.CategoryModels;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public interface ICategorySevice {
    ResponseEntity<List<CategoryModels>> getAllCategories();
    ResponseEntity<CategoryModels> getCategory(Long id);
    ResponseEntity<CategoryModels> saveCategory(CategoryModels category);
    ResponseEntity<CategoryModels> updateCategory(CategoryModels category, Long id);
    ResponseEntity<Object> deleteCategory(Long id);

    ResponseEntity<CategoryModels> getCategoryName(String name);
}
