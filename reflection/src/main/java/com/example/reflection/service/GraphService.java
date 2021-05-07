package com.example.reflection.service;

import graphql.ExecutionResult;

public interface GraphService {
	ExecutionResult excute(String query);
}
