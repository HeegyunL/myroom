package com.example.myroom.controller;

import com.example.myroom.dto.Blog;
import com.example.myroom.repository.BlogRepository;
import com.example.myroom.service.MainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class MainController {
	private final BlogRepository blogRepo;
	private MainService mainService;

	public MainController(BlogRepository blogRepo) {
		this.blogRepo = blogRepo;
	}

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		List<Blog> blogList = blogRepo.findAll();

		mav.setViewName("index");
		return mav;
	}
	@GetMapping("/work")
	public ModelAndView work() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("services/work/workAdd");
		return mav;
	}
	@GetMapping("/work/{id}")
	public ModelAndView workDetail(@PathVariable("id") Long id, HttpServletResponse response) {

		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		Optional<Blog> blog = blogRepo.findById(id);
		mav.addObject("blog", blog.get());
		mav.setViewName("services/work/workDetail");
		return mav;
	}
	@GetMapping("/gallery")
	public ModelAndView gallery() {
		ModelAndView mav = new ModelAndView();
		List<Blog> blogList = blogRepo.findAll();


		mav.addObject("blog", blogList);
		System.out.println(blogList);
		mav.setViewName("services/gallery/galleryMain");
		return mav;
	}



	@PostMapping("/work/add")
	public ModelAndView blogAdd(Blog blog, @RequestParam("file") MultipartFile file) throws IOException {
		ModelAndView mav = new ModelAndView();

		//현재 시간
		blog.setWrittenTime(mainService.nowDate());

		Long fileNumber = blogRepo.findFirstByOrderByIdDesc().get().getId() + 1;
		String[] name = file.getOriginalFilename().split("[.]");
		String fileExtention = name[name.length -1];


		if (!file.isEmpty()) {
			String filePath = "/Users/hee/Documents/project/portfolio/myroom/myroom/src/main/webapp/assets/img/work/" + fileNumber+"."+fileExtention;
			blog.setFileName(file.getOriginalFilename());
			file.transferTo(new File(filePath));
			blog.setFileUrl("/assets/img/work/" + fileNumber+"."+fileExtention);
			Blog addBlog = blogRepo.save(blog);
		}


		mav.setViewName("index");
		return mav;
	}



}
