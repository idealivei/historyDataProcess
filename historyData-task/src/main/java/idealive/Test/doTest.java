package idealive.Test;


import java.util.Date;

import idealive.db.dataProcess;
import idealive.module.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class doTest {
    @Autowired
    public static dataProcess action;
    public static void main(String[] args){
        ConfigurableApplicationContext tx = SpringApplication.run(doTest.class, args);
        action = tx.getBean(dataProcess.class);

        for (int i = 0; i < 100; i++) {
            action.AddOrder(new order(String.valueOf(i),new Date()));
        }
    }


}
