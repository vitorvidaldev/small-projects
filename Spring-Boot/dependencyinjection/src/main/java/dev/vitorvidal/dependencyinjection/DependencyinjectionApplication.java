package dev.vitorvidal.dependencyinjection;

import dev.vitorvidal.dependencyinjection.controller.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyinjectionApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DependencyinjectionApplication.class, args);
        MyController controller = (MyController) context.getBean("myController");

        String greeting = controller.sayHello();
        System.out.println(greeting);
    }

}
