package com.motional.cthye.taxibookingsystem;

import com.motional.cthye.taxibookingsystem.model.World;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaxibookingsystemApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TaxibookingsystemApplication.class);
    }

    public static void main(String[] args) {
        World.getInstance().reset();
        SpringApplication.run(TaxibookingsystemApplication.class, args);
    }

    @Bean
    public World getWorld() {
        return World.getInstance();
    }

}
