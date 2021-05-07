package com.example.reflection.config;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.example.reflection.service.BookFatcher;
import com.example.reflection.service.BooksFatcher;

import graphql.GraphQL;
import graphql.GraphQL.Builder;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class GraphQLConfig {
	
	@Value("classpath:/graphql/book_schema.graphqls")
	Resource resource;
	
	private final BookFatcher bookFatcher;
	
	private final BooksFatcher booksFatcher;
	
	private final ApplicationContext ac;
	
	@Bean
	public Builder builder() {	
		Builder builder = null;
		Map<String, Object> classes = ac.getBeansWithAnnotation(GsGraph.class);
		classes.entrySet().forEach(clazz->{
			Class _class = clazz.getValue().getClass();
			GsGraph annotation = (GsGraph) _class.getDeclaredAnnotation(GsGraph.class);
			System.out.println(annotation.value());
			System.out.println("classname :  " + _class);
		});
		return builder;
	}
	
	@Bean
	public GraphQL graphQL() throws IOException {
	
		File schemaFile = resource.getFile();
		
		SchemaParser schemaParser = new SchemaParser();
		
		TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schemaFile);
		
		RuntimeWiring wiring = RuntimeWiring.newRuntimeWiring()
				.type("Query", typeWiring -> typeWiring.dataFetcher("getBook", bookFatcher))
				.type("Query", typeWiring -> typeWiring.dataFetcher("getBooks", booksFatcher))
				.build();
		
		 GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, wiring);
	     GraphQL graphQL = GraphQL.newGraphQL(schema).build();
		
		return graphQL;
	}
}
