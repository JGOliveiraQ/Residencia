package br.com.stockmanager.dto;
public record SupplierResponse(Long id,String corporateName,String tradeName,String cnpj,String phone,String email,String address,String city,String state,boolean active){}
