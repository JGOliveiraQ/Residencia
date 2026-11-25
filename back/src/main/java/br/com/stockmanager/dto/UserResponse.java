package br.com.stockmanager.dto;
import br.com.stockmanager.enums.UserRole; public record UserResponse(Long id,String name,String email,UserRole role,boolean active){}
