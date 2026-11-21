package br.com.stockmanager.controller;
import br.com.stockmanager.dto.*; import br.com.stockmanager.service.UserService; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/users") public class UserController{
 private final UserService service; public UserController(UserService service){this.service=service;}
 @GetMapping public List<UserResponse> findAll(){return service.findAll();} @GetMapping("/{id}") public UserResponse get(@PathVariable Long id){var u=service.get(id);return new UserResponse(u.getId(),u.getName(),u.getEmail(),u.getRole(),u.isActive());}
 @PostMapping public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest r){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(r));}
 @PatchMapping("/{id}/status") @ResponseStatus(HttpStatus.NO_CONTENT) public void status(@PathVariable Long id,@RequestParam boolean active){service.status(id,active);}
}
