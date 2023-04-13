package con.caja.ideal.controller;

import con.caja.ideal.models.CategoryModels;
import con.caja.ideal.service.ICategorySevice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/v1")
public class CategoryControlles {
    @Autowired
    private ICategorySevice sevice;

    @GetMapping("/category")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CategoryModels>> getAllCategory() {
        return sevice.getAllCategories();
    }

    @GetMapping("category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CategoryModels> getCategory(@PathVariable Long id) {
        return sevice.getCategory(id);
    }

    @GetMapping("category/type/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CategoryModels> category(@PathVariable(value = "name") String name) {
        return sevice.getCategoryName(name);
    }

    @PostMapping("/category")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CategoryModels> postCategory(@Valid @RequestBody CategoryModels category) {
        return sevice.saveCategory(category);
    }

    @PutMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CategoryModels> updateCategory(@Valid @RequestBody CategoryModels category, @PathVariable Long id) {
        return sevice.updateCategory(category, id);
    }

    @DeleteMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id){
        return sevice.deleteCategory(id);
    }
}
