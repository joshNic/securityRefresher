package com.example.securityrefresher;

import com.example.securityrefresher.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SecurityRefresherApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityRefresherApplication.class, args);
    }

}
