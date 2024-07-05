package com.example.myroom.dto;

import java.util.Date;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@NoArgsConstructor
@Data
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String content;
	private String category;
	private String writtenTime;
	private String writer;



}
