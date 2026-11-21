package br.com.stockmanager.service;
import br.com.stockmanager.dto.*; import br.com.stockmanager.entity.User; import br.com.stockmanager.exception.*; import br.com.stockmanager.repository.UserRepository; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import java.util.*;
@Service public class UserService{
 private final UserRepository repo; private final PasswordEncoder encoder; public UserService(UserRepository repo,PasswordEncoder encoder){this.repo=repo;this.encoder=encoder;}
 @Transactional(readOnly=true) public List<UserResponse> findAll(){return repo.findAll().stream().map(this::response).toList();}
 @Transactional(readOnly=true) public User get(Long id){return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Usuário não encontrado."));}
 @Transactional public UserResponse create(UserRequest r){if(repo.existsByEmailIgnoreCase(r.email()))throw new DuplicateResourceException("E-mail já cadastrado.");return response(repo.save(new User(r.name(),r.email().trim().toLowerCase(Locale.ROOT),encoder.encode(r.password()),r.role())));}
 @Transactional public void status(Long id,boolean active){get(id).setActive(active);}
 private UserResponse response(User u){return new UserResponse(u.getId(),u.getName(),u.getEmail(),u.getRole(),u.isActive());}
}
