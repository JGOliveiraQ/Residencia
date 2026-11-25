package br.com.stockmanager.service;
import br.com.stockmanager.repository.UserRepository; import org.springframework.security.core.userdetails.*; import org.springframework.stereotype.Service;
@Service public class UserDetailsServiceImpl implements UserDetailsService{
 private final UserRepository repo; public UserDetailsServiceImpl(UserRepository repo){this.repo=repo;}
 public UserDetails loadUserByUsername(String email){var u=repo.findByEmailIgnoreCase(email).orElseThrow(()->new UsernameNotFoundException("Usuário não encontrado."));return org.springframework.security.core.userdetails.User.withUsername(u.getEmail()).password(u.getPassword()).roles(u.getRole().name()).disabled(!u.isActive()).build();}
}
