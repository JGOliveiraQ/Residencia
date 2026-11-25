package br.com.stockmanager.controller;
import br.com.stockmanager.dto.*; import br.com.stockmanager.service.CategoryService; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/categories") public class CategoryController{
 private final CategoryService service; public CategoryController(CategoryService service){this.service=service;}
 @GetMapping public List<CategoryResponse> findAll(){return service.findAll();} @PostMapping public ResponseEntity<CategoryResponse> create(@Valid @RequestBody CategoryRequest r){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(r));}
 @PutMapping("/{id}") public CategoryResponse update(@PathVariable Long id,@Valid @RequestBody CategoryRequest r){return service.update(id,r);}
 @PatchMapping("/{id}/status") @ResponseStatus(HttpStatus.NO_CONTENT) public void status(@PathVariable Long id,@RequestParam boolean active){service.status(id,active);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){service.status(id,false);}
}
