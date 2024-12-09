package gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

public class Api {
    /* TODO: First steps for CREATE method:
    create a route for /api/newPerson
    Initialize a new array suitable for JSON data
    Populate new array with type Person using test data
    */
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes() 
            .route(p -> p
            .path("/api/newPerson")
            .filters(f -> f.addRequestHeader("Hello", "World"))
            .uri("http://httpbin.org:80"))
        .build();
    }
}
