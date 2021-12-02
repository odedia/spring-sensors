package org.tanzu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;

@SpringBootApplication
public class SensorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SensorsApplication.class, args);
    }
    
   	@Bean
    public HttpTraceRepository htttpTraceRepository() {
            return new InMemoryHttpTraceRepository();
    }
}
