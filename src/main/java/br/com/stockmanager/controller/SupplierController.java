package br.com.stockmanager.controller;
import br.com.stockmanager.dto.*; import br.com.stockmanager.service.SupplierService; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/suppliers") public class SupplierController{
 private final SupplierService service; public SupplierController(SupplierService service){this.service=service;}
 @GetMapping public List<SupplierResponse> findAll(){return service.findAll();} @GetMapping("/{id}") public SupplierResponse get(@PathVariable Long id){var s=service.get(id);return new SupplierResponse(s.getId(),s.getCorporateName(),s.getTradeName(),s.getCnpj(),s.getPhone(),s.getEmail(),s.getAddress(),s.getCity(),s.getState(),s.isActive());}
 @PostMapping public ResponseEntity<SupplierResponse> create(@Valid @RequestBody SupplierRequest r){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(r));}
 @PutMapping("/{id}") public SupplierResponse update(@PathVariable Long id,@Valid @RequestBody SupplierRequest r){return service.update(id,r);}
 @PatchMapping("/{id}/status") @ResponseStatus(HttpStatus.NO_CONTENT) public void status(@PathVariable Long id,@RequestParam boolean active){service.status(id,active);}
}
