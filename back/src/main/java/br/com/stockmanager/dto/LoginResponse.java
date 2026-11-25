package br.com.stockmanager.dto;
public record LoginResponse(String token,String tokenType,long expiresIn,UserResponse user){}
