package com.example.demo.mapper;

import java.util.List;
import org.mapstruct.Mapper;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {

	List<Book> listDtoBookToListBook(List<BookDto> listBookDto);
	
	List<BookDto> listBookToListDtoBook(List<Book> listBookEntity);
	
	Book bookDtoToBook(BookDto bookDto);
	
	BookDto bookToBookDto(Book bookEntity);

	
	
}
