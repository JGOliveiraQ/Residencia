package br.com.stockmanager.dto;
import jakarta.validation.constraints.NotBlank; public record CategoryRequest(@NotBlank String name,String description){}
