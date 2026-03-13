package com.proyecto.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.tienda.repository", "com.proyecto.proyecto.repository"})
@EntityScan(basePackages = {"com.tienda.domain", "com.proyecto.proyecto.domain"})
@ComponentScan(basePackages = {"com.tienda", "com.proyecto.proyecto"})
public class ProyectoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoApplication.class, args);
    }
}
