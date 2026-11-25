package br.com.stockmanager.repository;
import br.com.stockmanager.entity.StockMovement; import org.springframework.data.jpa.repository.JpaRepository;
public interface StockMovementRepository extends JpaRepository<StockMovement,Long>{long countByType(br.com.stockmanager.enums.MovementType type);}
