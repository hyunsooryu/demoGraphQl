package com.example.reflection.service;

import org.springframework.stereotype.Service;

import graphql.ExecutionResult;
import graphql.GraphQL;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class GraphServiceImpl implements GraphService{

	private final GraphQL graphQL;
	@Override
	public ExecutionResult excute(String query) {
		// TODO Auto-generated method stub
		return graphQL.execute(query);
	}
	

}
