package br.com.stockmanager.config;
import br.com.stockmanager.entity.User; import br.com.stockmanager.enums.UserRole; import br.com.stockmanager.repository.UserRepository; import org.springframework.beans.factory.annotation.Value; import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.*; import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration public class InitialAdminConfig{
 @Bean CommandLineRunner createInitialAdmin(UserRepository repo,PasswordEncoder encoder,@Value("${INITIAL_ADMIN_NAME:Administrador}") String name,@Value("${INITIAL_ADMIN_EMAIL:admin@exemplo.com}") String email,@Value("${INITIAL_ADMIN_PASSWORD:admin123456}") String password){return args->{if(!name.isBlank()&&!email.isBlank()&&!password.isBlank()&&repo.count()==0)repo.save(new User(name,email,encoder.encode(password),UserRole.ADMIN));};}
}
