package demo.io;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// Classe para criar configurações
@Configuration
// Nomeio esse perfil como dev
@Profile("prod")
public class ProdConfig {

    @Bean
    public BeanProd beanProd() {
        return new BeanProd();
    }

}
