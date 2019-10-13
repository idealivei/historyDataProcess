package idealive.Test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import idealive.db.dataProcess;
import idealive.module.order;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;

@Primary
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ImportResource(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml"})
@MapperScan("idealive.Test")
public class doTest {

    public static dataProcess action;
    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext tx = SpringApplication.run(doTest.class, args);
        action = tx.getBean(dataProcess.class);
        int a,b;
        System.out.println("请输入开始数");

        InputStreamReader reader = new InputStreamReader(System.in);
        a = cast(reader);
        System.out.println("请输入结束数");

        reader = new InputStreamReader(System.in);
        b = cast(reader);
        System.out.println("开始写数据，起止数分别是："+ a+","+b);
        for (int i = Integer.valueOf(a); i < Integer.valueOf(b); i++) {
            action.AddOrder(new order(String.valueOf(i),new Date()));
        }
    }

    private static int cast(InputStreamReader reader) throws IOException {

        BufferedReader input = new BufferedReader(reader);
        String s = input.readLine();/*执行输入流操作*/
        return Integer.parseInt(s);/*加个int型的转换*/
    }
}
