package io.pivotal.student.applications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Map;


@SpringBootApplication
@ComponentScan({"io.pivotal.student.userservice", "io.pivotal.student.restsupport"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Bean
    public Map<String,String> environmentVars(){
        Map<String,String> envs= System.getenv();
        return envs;
    }
}
