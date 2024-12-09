package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println();
	}

	/* TODO: First steps for CREATE method:
    create a route for /api/newPerson
    Initialize a new array suitable for JSON data
    Populate new array with type Person using test data
	When it works move this into its own file
    */
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		System.out.println("testiii");
		//TODO: is the route now created?
        return builder.routes() 
            .route("new-person", r -> r.path("/api/newPerson")
            	.uri("http://httpbin.org:80"))
        	.build();
    }
}
