package com.books.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookId;
	
	@NotNull(message = "Name of the Book Should Not Be Null")
	@NotBlank(message = "Field Should not be blank")
	private String bookName;
	
	@NotNull(message = "Author of the Book Should Not Be Null")
	@NotBlank(message = "Field Should not be blank")
	private String bookAuthor;
	
	@NotNull(message = "Publication of the Book Should Not Be Null")
	@NotBlank(message = "Field Should not be blank")
	private String publiction;
	
	@NotNull(message = "Category of the Book Should Not Be Null")
	@NotBlank(message = "Field Should not be blank")
	private String category;
	
	@NotNull(message = "Pages of the Book Should Not Be Null")
	private Long pages;
	
	@NotNull(message = "Price of the Book Should Not Be Null")
	@Min(1)
	private Double bookPrice;
	
}
