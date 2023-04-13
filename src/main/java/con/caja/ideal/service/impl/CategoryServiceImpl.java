package con.caja.ideal.service.impl;

import con.caja.ideal.exceptions.ResourceNotFoundException;
import con.caja.ideal.models.CategoryModels;
import con.caja.ideal.repository.ICategoryRepository;
import con.caja.ideal.service.ICategorySevice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategorySevice {
    @Autowired
    private ICategoryRepository repository;

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<List<CategoryModels>> getAllCategories() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<CategoryModels> getCategory(Long id) {
        CategoryModels category = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found category for id " + id));
        return ResponseEntity.ok(category);
    }

    @Transactional
    @Override
    public ResponseEntity<CategoryModels> saveCategory(CategoryModels category) {
        CategoryModels save = repository.save(category);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @Transactional
    @Override
    public ResponseEntity<CategoryModels> updateCategory(CategoryModels category, Long id) {
        CategoryModels categoryToUpdate = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("this id already exists " + id));
        BeanUtils.copyProperties(category, categoryToUpdate, "id");
        CategoryModels updated = repository.save(categoryToUpdate);
        return ResponseEntity.ok(updated);
    }

    @Transactional
    @Override
    public ResponseEntity<Object> deleteCategory(Long id) {
        HashMap<String, Object> response = new HashMap<>();
        Optional<CategoryModels> category = repository.findById(id);
        if (category.isPresent()) {
            repository.delete(category.get());
            response.put("Message", " successfully removed ");
            return ResponseEntity.ok(response);
        }
        response.put("Message", "Not found category for id ");
        return ResponseEntity.badRequest().body(response);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<CategoryModels> getCategoryName(String name) {
        CategoryModels categoryName = repository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("Not found category for".concat(name)));
        return ResponseEntity.ok(categoryName);
    }
}
