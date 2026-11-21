package br.com.stockmanager.config;
import org.springframework.beans.factory.annotation.Value; import org.springframework.context.annotation.*; import org.springframework.web.cors.*; import java.util.*;
@Configuration public class CorsConfig{
 @Bean public CorsConfigurationSource corsConfigurationSource(@Value("${app.cors.allowed-origin}") String origin){CorsConfiguration c=new CorsConfiguration();c.setAllowedOrigins(List.of(origin));c.setAllowedMethods(List.of("GET","POST","PUT","PATCH","DELETE","OPTIONS"));c.setAllowedHeaders(List.of("*"));c.setAllowCredentials(true);UrlBasedCorsConfigurationSource s=new UrlBasedCorsConfigurationSource();s.registerCorsConfiguration("/**",c);return s;}
}
