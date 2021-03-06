package com.non.valent;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableMethodCache(basePackages = "com.non.valent")
@EnableCreateCacheAnnotation
public class ServiceApplication {

	public static void main(String[] args) {
		//看这里，加上这句话
		System.setProperty("es.set.netty.runtime.available.processors","false");
		SpringApplication.run(ServiceApplication.class, args);
	}

}
