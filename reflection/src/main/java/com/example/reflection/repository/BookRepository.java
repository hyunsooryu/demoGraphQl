package com.example.reflection.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.reflection.beans.Book;
import com.example.reflection.beans.Category;

@Repository
public class BookRepository {
	private Map<String, Book> BookStore = new HashMap<String, Book>();
	
	public BookRepository(){
		BookStore.put("1", Book.builder().id("1").name("book-1").category(Category.COMEDY).build());
		BookStore.put("2", Book.builder().id("2").name("book-2").category(Category.HORROR).build());
		BookStore.put("3", Book.builder().id("3").name("book-3").category(Category.FANTASY).build());
	}

	public Book findBookById(String id) {
		return BookStore.getOrDefault(id, null);
	}
	
	public List<Book> findAllBooks() {	
		List<Book> tmpList = new ArrayList<>();
		BookStore.entrySet().stream().forEach(entry->{
			tmpList.add(entry.getValue());
		});	
		return tmpList;
	}

}
