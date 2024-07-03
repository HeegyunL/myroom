package com.example.myroom.controller;

import com.example.myroom.dto.Blog;
import com.example.myroom.repository.BlogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {
	private final BlogRepository blogRepo;

	public MainController(BlogRepository blogRepo) {
		this.blogRepo = blogRepo;
	}

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		List<Blog> blogList = blogRepo.findAll();

		mav.setViewName("/index");
		return mav;
	}
	@GetMapping("/work")
	public ModelAndView work() {
		ModelAndView mav = new ModelAndView();
		List<Blog> blogList = blogRepo.findAll();

		mav.setViewName("/services/work");
		return mav;
	}
	@GetMapping("/gallery")
	public ModelAndView gallery() {
		ModelAndView mav = new ModelAndView();
		List<Blog> blogList = blogRepo.findAll();

		mav.setViewName("/services/gallery");
		return mav;
	}
	@GetMapping("/news")
	public ModelAndView news() {
		ModelAndView mav = new ModelAndView();
		List<Blog> blogList = blogRepo.findAll();

		mav.setViewName("/services/news");
		return mav;
	}

	@PostMapping("/work/add")
	public ModelAndView blogAdd(Blog blog) throws IOException {
		ModelAndView mav = new ModelAndView();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nowDate = new Date();
		blog.setWrittenTime(dateFormat.format(nowDate));


		Blog addBlog = blogRepo.save(blog);

		mav.setViewName("/index");
		return mav;
	}

}
