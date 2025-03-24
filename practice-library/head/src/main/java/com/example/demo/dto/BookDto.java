package com.example.demo.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Date;


@Data
@AllArgsConstructor
public class BookDto {

	private Long id;
	private String name;
	private String editorial;
	private Date creationDate;
	private String ean;
}
