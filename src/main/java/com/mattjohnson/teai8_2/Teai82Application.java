package com.mattjohnson.teai8_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Teai82Application {

    public static void main(String[] args) {
        SpringApplication.run(Teai82Application.class, args);
    }

}
