package com.example.reflection.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.reflection.beans.Book;
import com.example.reflection.config.GsGraph;
import com.example.reflection.repository.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;


@GsGraph("QueryBooksFatcher")
@RequiredArgsConstructor
public class BooksFatcher implements DataFetcher<List<Book>> {

	private final BookRepository bookRepository;
	
	@Override
	public List<Book> get(DataFetchingEnvironment environment) {
		// TODO Auto-generated method stub
		return bookRepository.findAllBooks();
	}

}
