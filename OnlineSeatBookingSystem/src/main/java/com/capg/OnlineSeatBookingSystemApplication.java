package com.capg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@SpringBootApplication
@EnableSwagger2
public class OnlineSeatBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineSeatBookingSystemApplication.class, args);
//		SpringApplication app = new SpringApplication(OnlineSeatBookingSystemApplication.class);
//        app.setDefaultProperties(Collections
//          .singletonMap("server.port", "8085"));
//        app.run(args);
	}

}
