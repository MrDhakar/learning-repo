package com.jaid.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
/* @EnableConfigurationProperties(UriConfiguration.class) */
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	/*
	 * @Bean public RouteLocator myRoutes(RouteLocatorBuilder builder,
	 * UriConfiguration uriConfiguration) { String httpUri =
	 * uriConfiguration.getHttpbin(); return builder.routes() .route(p ->
	 * p.path("/get").filters(f -> f.addRequestHeader("Hello", "World"))
	 * 
	 * .uri(httpUri)) .route(p -> p.host("*localhost") .filters( f ->
	 * f.circuitBreaker(config ->
	 * config.setName("jaidBreaker").setFallbackUri("forward:/fallback")) )
	 * 
	 * .uri(httpUri)) .build(); }
	 * 
	 * @RequestMapping("/fallback") public Mono<String> fallback() { return
	 * Mono.just("fallback"); }
	 */
}

/*
 * @ConfigurationProperties class UriConfiguration {
 * 
 * private String httpbin = "http://localhost:9090";
 * 
 * public String getHttpbin() { return httpbin; }
 * 
 * public void setHttpbin(String httpbin) { this.httpbin = httpbin; } }
 */
