package org.framework.rodolfo.freire.git.encryption.symmetric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.framework.rodolfo.freire.git.encryption.*")
public class SymmetricApplication {

    public static void main(String[] args) {
        SpringApplication.run(SymmetricApplication.class, args);
    }
}
