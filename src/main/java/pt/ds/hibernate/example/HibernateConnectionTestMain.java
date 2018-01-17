package pt.ds.hibernate.example;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import pt.ds.hibernate.example.config.HibernateExampleAppConfig;
import pt.ds.hibernate.example.config.MysqlConfig;

@Slf4j
public class HibernateConnectionTestMain {

    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                HibernateExampleAppConfig.class);

        // get the bean from spring container
        MysqlConfig sqlConfig = context.getBean("mysqlConfig", MysqlConfig.class);
        log.info("MYSQL config:: " + sqlConfig);
        try {
            Connection myCon = DriverManager
                    .getConnection(sqlConfig.getUrl(), sqlConfig.getUsername(), sqlConfig.getPassword());
            log.info("MYSQL connection established");
        } catch (Exception ex) {
            log.error("Failed to establish connection", ex);
        }
        context.close();
    }

}


