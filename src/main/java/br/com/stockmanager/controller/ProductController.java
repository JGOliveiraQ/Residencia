package br.com.stockmanager.controller;
import br.com.stockmanager.dto.*; import br.com.stockmanager.service.ProductService; import jakarta.validation.Valid; import org.springframework.data.domain.*; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/products") public class ProductController{
 private final ProductService service; public ProductController(ProductService service){this.service=service;}
 @GetMapping public Page<ProductResponse> find(@RequestParam(required=false) String search,Pageable pageable){return service.find(search,pageable);}
 @GetMapping("/{id}") public ProductResponse get(@PathVariable Long id){var p=service.get(id);return new ProductResponse(p.getId(),p.getSku(),p.getName(),p.getDescription(),p.getBrand(),p.getUnit(),p.getCostPrice(),p.getSalePrice(),p.getCurrentStock(),p.getMinimumStock(),p.isActive(),p.getCategory().getId(),p.getCategory().getName());}
 @PostMapping public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest r){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(r));}
 @PutMapping("/{id}") public ProductResponse update(@PathVariable Long id,@Valid @RequestBody ProductRequest r){return service.update(id,r);}
 @PatchMapping("/{id}/status") @ResponseStatus(HttpStatus.NO_CONTENT) public void status(@PathVariable Long id,@RequestParam boolean active){service.status(id,active);}
 @GetMapping("/low-stock") public List<ProductResponse> lowStock(){return service.lowStock();}
 @GetMapping("/out-of-stock") public List<ProductResponse> outOfStock(){return service.outOfStock();}
}
