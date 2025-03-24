package com.example.demo.mapper;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-19T17:42:35+0100",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public List<Book> listDtoBookToListBook(List<BookDto> listBookDto) {
        if ( listBookDto == null ) {
            return null;
        }

        List<Book> list = new ArrayList<Book>( listBookDto.size() );
        for ( BookDto bookDto : listBookDto ) {
            list.add( bookDtoToBook( bookDto ) );
        }

        return list;
    }

    @Override
    public List<BookDto> listBookToListDtoBook(List<Book> listBookEntity) {
        if ( listBookEntity == null ) {
            return null;
        }

        List<BookDto> list = new ArrayList<BookDto>( listBookEntity.size() );
        for ( Book book : listBookEntity ) {
            list.add( bookToBookDto( book ) );
        }

        return list;
    }

    @Override
    public Book bookDtoToBook(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        Date creationDate = null;
        String ean = null;
        String editorial = null;
        Long id = null;
        String name = null;

        creationDate = bookDto.getCreationDate();
        ean = bookDto.getEan();
        editorial = bookDto.getEditorial();
        id = bookDto.getId();
        name = bookDto.getName();

        Book book = new Book( id, name, editorial, creationDate, ean );

        return book;
    }

    @Override
    public BookDto bookToBookDto(Book bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }

        Date creationDate = null;
        String ean = null;
        String editorial = null;
        Long id = null;
        String name = null;

        creationDate = bookEntity.getCreationDate();
        ean = bookEntity.getEan();
        editorial = bookEntity.getEditorial();
        id = bookEntity.getId();
        name = bookEntity.getName();

        BookDto bookDto = new BookDto( id, name, editorial, creationDate, ean );

        return bookDto;
    }
}
