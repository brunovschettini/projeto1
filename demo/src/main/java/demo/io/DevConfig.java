package demo.io;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// Classe para criar configurações
@Configuration
// Nomeio esse perfil como dev
@Profile("dev")
public class DevConfig {

    @Bean
    public BeanDev beanDev() {
        return new BeanDev();
    }

}
