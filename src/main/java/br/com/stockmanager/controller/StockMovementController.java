package br.com.stockmanager.controller;
import br.com.stockmanager.dto.*; import br.com.stockmanager.enums.MovementType; import br.com.stockmanager.service.StockMovementService; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.security.core.Authentication; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/stock-movements") public class StockMovementController{
 private final StockMovementService service; public StockMovementController(StockMovementService service){this.service=service;}
 @PostMapping("/entries") public ResponseEntity<MovementResponse> entry(@Valid @RequestBody MovementRequest r,Authentication a){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(MovementType.ENTRY,r,a.getName()));}
 @PostMapping("/exits") public ResponseEntity<MovementResponse> exit(@Valid @RequestBody MovementRequest r,Authentication a){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(MovementType.EXIT,r,a.getName()));}
 @PostMapping("/adjustments") public ResponseEntity<MovementResponse> adjustment(@Valid @RequestBody MovementRequest r,Authentication a){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(MovementType.ADJUSTMENT,r,a.getName()));}
 @GetMapping public List<MovementResponse> findAll(){return service.findAll();} @GetMapping("/{id}") public MovementResponse get(@PathVariable Long id){return service.get(id);}
}
