package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService service;

	@GetMapping("/see-books")
	public List<BookDto> getBooks() {
		return service.getListBooks();
	}
	@GetMapping("/see-book/{id}")
	public Optional<BookDto> findBooks(@PathVariable Long id) {
		return service.getById(id);
	}

	@PostMapping("/create-book")
	public Book createCustomer(@RequestBody BookDto bookDto) {
		return service.createBook(bookDto);
	}

	@PutMapping("/update-book/{id}")
	public Book updateCustomer(@RequestBody BookDto book, @PathVariable Long id) throws Exception {
		return service.update(book, id);
	}

	@DeleteMapping("/remove-book/{id}")
	public String delete(@PathVariable Long id) {
		return service.remove(id);
	}
}

}