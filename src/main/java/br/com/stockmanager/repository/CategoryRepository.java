package br.com.stockmanager.repository;
import br.com.stockmanager.entity.Category; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface CategoryRepository extends JpaRepository<Category,Long>{Optional<Category> findByNormalizedName(String name); }
