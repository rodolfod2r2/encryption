package org.framework.rodolfo.freire.git.encryption.asymmetric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.framework.rodolfo.freire.git.encryption.*")
public class AsymmetricApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsymmetricApplication.class, args);
    }
}
