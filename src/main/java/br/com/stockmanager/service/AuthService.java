package br.com.stockmanager.service;
import br.com.stockmanager.dto.*; import br.com.stockmanager.security.JwtService; import org.springframework.security.authentication.*; import org.springframework.stereotype.Service;
@Service public class AuthService{
 private final AuthenticationManager authentication; private final UserDetailsServiceImpl details; private final JwtService jwt; private final br.com.stockmanager.repository.UserRepository users;
 public AuthService(AuthenticationManager authentication,UserDetailsServiceImpl details,JwtService jwt,br.com.stockmanager.repository.UserRepository users){this.authentication=authentication;this.details=details;this.jwt=jwt;this.users=users;}
 public LoginResponse login(LoginRequest request){authentication.authenticate(new UsernamePasswordAuthenticationToken(request.email(),request.password()));var u=users.findByEmailIgnoreCase(request.email()).orElseThrow();return new LoginResponse(jwt.generate(u),"Bearer",jwt.expiration(),new UserResponse(u.getId(),u.getName(),u.getEmail(),u.getRole(),u.isActive()));}
 public UserResponse me(String email){var u=users.findByEmailIgnoreCase(email).orElseThrow();return new UserResponse(u.getId(),u.getName(),u.getEmail(),u.getRole(),u.isActive());}
}
