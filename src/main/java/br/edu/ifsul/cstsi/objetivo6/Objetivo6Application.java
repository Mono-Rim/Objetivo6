package br.edu.ifsul.cstsi.objetivo6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Objetivo6Application {
    public static void main(String[] args) {
        SpringApplication.run(Objetivo6Application.class, args);
        HomeController.main(null);
    }
}
