package iesrafaelalberti.apitarea;

import iesrafaelalberti.apitarea.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class ApiTareaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTareaApplication.class, args);
    }

}