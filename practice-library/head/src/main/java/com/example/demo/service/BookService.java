package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;

@Service
public interface BookService {

	List<BookDto> getListBooks(); //obtener lista de libros 
	Optional<BookDto> getById(Long id);
	Book createBook(BookDto book);
	Book update(BookDto bookDto, Long id) throws Exception;
	String remove(Long id);
	

}
