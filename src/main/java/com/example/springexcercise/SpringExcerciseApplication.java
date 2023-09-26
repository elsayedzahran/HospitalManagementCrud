package com.example.springexcercise;

import com.example.springexcercise.repository.config.RepositoryConfig;
import com.example.springexcercise.rest.config.RestConfig;
import com.example.springexcercise.service.config.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
        RepositoryConfig.class,
        ServiceConfig.class,
        RestConfig.class
}
)
public class SpringExcerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringExcerciseApplication.class, args);
    }

}
