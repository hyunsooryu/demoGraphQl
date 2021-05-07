package com.example.reflection.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ResourceTest {
	public static void main(String[] args) {
			AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(GraphQLConfig.class);
			
	}
}
