package io.aula31;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Geral implements ApplicationListener<ContextRefreshedEvent> {

    // Este parâmetro esta no application.properties
    @Value("${geral.nome}")
    private String nome;

    // Este parâmetro esta no application.yml https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html
    @Value("${my.server}")
    private String server;

    // Executa ao iniciar a aplicação
    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        System.out.println("teste geral");
        System.out.println("teste do application properties " + nome);
        System.out.println("teste do application.yml " + server);
    }

}
