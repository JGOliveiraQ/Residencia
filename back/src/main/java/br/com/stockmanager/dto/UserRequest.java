package br.com.stockmanager.dto;
import br.com.stockmanager.enums.UserRole; import jakarta.validation.constraints.*;
public record UserRequest(@NotBlank String name,@NotBlank @Email String email,String password,@NotNull UserRole role){}
