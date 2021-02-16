package com.application.database.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.http.converter.protobuf.ProtobufJsonFormatHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class DemdatabaseApplication1Application {

	public static void main(String[] args) {
		SpringApplication.run(DemdatabaseApplication1Application.class, args);
	}
	@Bean
	public ProtobufHttpMessageConverter protobufJsonFormatHttpMessageConverter() {
		return new ProtobufHttpMessageConverter();
	}


	@Bean
	public RestTemplate restTemplate() {
		ProtobufHttpMessageConverter httpMessageConverter = new ProtobufHttpMessageConverter();
		ProtobufJsonFormatHttpMessageConverter protobufJsonFormatHttpMessageConverter = new ProtobufJsonFormatHttpMessageConverter();
		return new RestTemplate(Arrays.asList(httpMessageConverter, protobufJsonFormatHttpMessageConverter));
	}
}

