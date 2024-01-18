package com.amorim.imagiliteapi;

import com.amorim.imagiliteapi.domain.entity.Image;
import com.amorim.imagiliteapi.domain.enums.ImageExtension;
import com.amorim.imagiliteapi.infra.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ImagiliteapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImagiliteapiApplication.class, args);
    }

}
