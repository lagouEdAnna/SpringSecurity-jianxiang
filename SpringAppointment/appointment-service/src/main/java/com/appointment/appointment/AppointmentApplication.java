package com.appointment.appointment;

import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;

import com.appointment.appointment.filter.AuthorizationHeaderInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;

@SpringCloudApplication
@EnableResourceServer
public class AppointmentApplication {

//	@Bean
//	@LoadBalanced
//	public RestTemplate getRestTemplate(){
//		return new RestTemplate();
//	}

	@Primary
	@Bean
	@LoadBalanced
	public RestTemplate getCustomRestTemplate() {
		RestTemplate template = new RestTemplate();
		List<ClientHttpRequestInterceptor> interceptors = template.getInterceptors();
		if (interceptors == null) {
			template.setInterceptors(Collections.singletonList(new AuthorizationHeaderInterceptor()));
		} else {
			interceptors.add(new AuthorizationHeaderInterceptor());
			template.setInterceptors(interceptors);
		}

		return template;
	}


    public static void main(String[] args) {
        SpringApplication.run(AppointmentApplication.class, args);
    }
}

