package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.repository.BookDao;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private BookMapper mapper;

	@Override
	public List<BookDto> getListBooks() {
		List<BookDto> listBooks = this.mapper.listBookToListDtoBook( bookDao.findAll());
		return listBooks;
	}

	

	@Override
	public Optional<BookDto> getById(Long id) {
		Optional<Book> book = bookDao.findById(id);
		if (!book.isEmpty()) {
			return Optional.ofNullable(this.mapper.bookToBookDto(book.get()));
		}
		return Optional.empty();
	}

	@Override
	public Book createBook(BookDto bookDto) {
		Book book = bookDao.save(this.mapper.bookDtoToBook(bookDto));
		return book;
	}

	@Override
	public Book update(BookDto bookDto, Long id) throws Exception {
		Optional<Book> foundBook = bookDao.findById(id);
		if (foundBook.isPresent()) {
			return bookDao.save(this.mapper.bookDtoToBook(bookDto));
		} else {
			throw new Exception("THE BOOK DOESNT EXIST IN THE DATABASE");
		}
	}

	@Override
	public String remove(Long id) {
		bookDao.deleteById(id);
		return "The book has been succesfully deleted";
	}

}
