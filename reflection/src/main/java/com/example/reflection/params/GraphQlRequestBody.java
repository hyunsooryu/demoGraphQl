package com.example.reflection.params;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GraphQlRequestBody {

    private String query;
    private String operationName;
    private Map<String , Object> variable;


}
