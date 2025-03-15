package projetoArtigos.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Libera todas as rotas
                        .allowedOrigins("*") // Permite requisições de qualquer domínio
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos liberados
                        .allowedHeaders("*") // Permite todos os headers
                        .allowCredentials(false); // Não requer credenciais
            }
        };
    }
}
