package br.com.stockmanager.dto;
import br.com.stockmanager.enums.UserRole; import jakarta.validation.constraints.*;
public record UserRequest(@NotBlank String name,@NotBlank @Email String email,@NotBlank @Size(min=8) String password,@NotNull UserRole role){}
