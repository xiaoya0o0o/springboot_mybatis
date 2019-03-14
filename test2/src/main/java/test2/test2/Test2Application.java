package test2.test2;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//@SpringBootApplication
@EnableCaching
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class Test2Application {

    public static void main(String[] args) {
        SpringApplication.run(Test2Application.class, args);
    }

}
