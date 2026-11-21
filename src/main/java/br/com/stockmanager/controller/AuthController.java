package br.com.stockmanager.controller;
import br.com.stockmanager.dto.*; import br.com.stockmanager.service.AuthService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*; import org.springframework.security.core.Authentication;
@RestController @RequestMapping("/api/auth") public class AuthController{
 private final AuthService service; public AuthController(AuthService service){this.service=service;}
 @PostMapping("/login") public LoginResponse login(@Valid @RequestBody LoginRequest r){return service.login(r);}
 @GetMapping("/me") public UserResponse me(Authentication a){return service.me(a.getName());}
}
