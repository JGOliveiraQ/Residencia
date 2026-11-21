package br.com.stockmanager.dto;
import jakarta.validation.constraints.*; public record SupplierRequest(@NotBlank String corporateName,String tradeName,@NotBlank String cnpj,String phone,@Email String email,String address,String city,@Size(min=2,max=2) String state){}
