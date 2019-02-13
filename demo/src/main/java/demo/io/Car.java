package demo.io;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// Uso duas implementações para o msm serviço então uso @Qualifier("name....")
@Qualifier("carBean")
public class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Start car");
    }

    @Override
    public void stop() {
        System.out.println("Stop car");
    }

}
