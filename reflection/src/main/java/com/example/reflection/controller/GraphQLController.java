package com.example.reflection.controller;

import java.util.Map;

import javax.annotation.Nullable;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.reflection.params.GraphQlRequestBody;
import com.example.reflection.service.GraphService;

import graphql.ExecutionResult;
import graphql.GraphQL;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GraphQLController {
	
	private final GraphService graphService;
	
	@PostMapping(value="/graphql",
			                       consumes = MediaType.APPLICATION_JSON_VALUE,
			                       produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> execute(@RequestBody GraphQlRequestBody body){
			return graphService.excute(body.getQuery()).toSpecification();
	}
	

}
