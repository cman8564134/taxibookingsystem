package com.motional.cthye.taxibookingsystem;

import com.motional.cthye.taxibookingsystem.model.World;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaxibookingsystemApplication {

    public static void main(String[] args) {
        World.getInstance().reset();
        SpringApplication.run(TaxibookingsystemApplication.class, args);
    }

}
