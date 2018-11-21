package pl.coderslab.springhibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.springhibernate.config.AppConfig;

public class SpringDIApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);



    }
}
