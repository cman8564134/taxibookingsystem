package com.motional.cthye.taxibookingsystem;

import com.motional.cthye.taxibookingsystem.model.World;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaxibookingsystemApplication {

    public static void main(String[] args) {
        World.getInstance().reset();
        SpringApplication.run(TaxibookingsystemApplication.class, args);
    }

    @Bean
    public World getWorld() {
        return World.getInstance();
    }

}
