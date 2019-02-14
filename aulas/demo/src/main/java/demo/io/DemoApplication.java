package demo.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // SpringApplication.run(DemoApplication.class, args);

        // Para selecionar o perfil va em arquivo de configuração application.application
        SpringApplication.run(DemoApplication.class, args);
                
//        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
//
//        MyController controller = (MyController) ctx.getBean("myController");
//
//        // Para o teste existem duas classes iguais na implementação
//        // Então eu devo usar @Qualifier para corrigir isso, e especificar qual classe implementada de Vehicle herdada será o service executado        
//        VehicleComponent vehicleComponent = (VehicleComponent) ctx.getBean("vehicleComponent");
//
//        vehicleComponent.service();
    }

}
