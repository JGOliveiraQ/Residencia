package br.com.stockmanager.service;
import br.com.stockmanager.dto.*; import br.com.stockmanager.entity.User; import br.com.stockmanager.exception.*; import br.com.stockmanager.repository.UserRepository; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import java.util.*;
@Service public class UserService{
 private final UserRepository repo; private final PasswordEncoder encoder; public UserService(UserRepository repo,PasswordEncoder encoder){this.repo=repo;this.encoder=encoder;}
 @Transactional(readOnly=true) public List<UserResponse> findAll(){return repo.findAll().stream().map(this::response).toList();}
 @Transactional(readOnly=true) public User get(Long id){return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Usuário não encontrado."));}
 @Transactional public UserResponse create(UserRequest r){if(r.password()==null||r.password().trim().length()<8)throw new BusinessException("A senha deve ter no mínimo 8 caracteres.");if(repo.existsByEmailIgnoreCase(r.email()))throw new DuplicateResourceException("E-mail já cadastrado.");return response(repo.save(new User(r.name().trim(),r.email().trim().toLowerCase(Locale.ROOT),encoder.encode(r.password().trim()),r.role())));}
 @Transactional public UserResponse update(Long id,UserRequest r){User u=get(id);repo.findByEmailIgnoreCase(r.email().trim()).filter(x->!x.getId().equals(id)).ifPresent(x->{throw new DuplicateResourceException("E-mail já cadastrado.");});u.setName(r.name().trim());u.setEmail(r.email().trim().toLowerCase(Locale.ROOT));u.setRole(r.role());if(r.password()!=null&&!r.password().isBlank()){if(r.password().trim().length()<8)throw new BusinessException("A senha deve ter no mínimo 8 caracteres.");u.setPassword(encoder.encode(r.password().trim()));}return response(u);}
 @Transactional public void status(Long id,boolean active){get(id).setActive(active);}
 private UserResponse response(User u){return new UserResponse(u.getId(),u.getName(),u.getEmail(),u.getRole(),u.isActive());}
}
