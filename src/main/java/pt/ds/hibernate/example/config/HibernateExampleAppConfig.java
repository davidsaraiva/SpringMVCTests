package pt.ds.hibernate.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "pt.ds.hibernate.example")
@PropertySource("classpath:hibernate_app.properties")
public class HibernateExampleAppConfig {

}
