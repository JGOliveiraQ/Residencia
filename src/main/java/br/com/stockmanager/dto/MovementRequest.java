package br.com.stockmanager.dto;
import br.com.stockmanager.enums.ExitReason; import jakarta.validation.Valid; import jakarta.validation.constraints.*; import java.util.List;
public record MovementRequest(String description,ExitReason reason,Long supplierId,@NotEmpty List<@Valid MovementItemRequest> items){}
