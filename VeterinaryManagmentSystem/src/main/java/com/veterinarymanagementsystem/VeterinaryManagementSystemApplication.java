package com.veterinarymanagementsystem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Veteriner Yönetim Sistemi", version = "1.0", description = "Hasta ve doktor ile ilgili kayıt etme,silme ve güncelleme işlemlerinin yapıldığı uygulama."))
public class VeterinaryManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(VeterinaryManagementSystemApplication.class, args);
    }

}
