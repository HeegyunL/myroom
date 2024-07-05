package com.example.myroom.controller;

import com.example.myroom.dto.Blog;
import com.example.myroom.repository.BlogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public String home() {
		ModelAndView mav = new ModelAndView();
		List<Blog> blogList = blogRepo.findAll();

		mav.setViewName("index");
		return "index";
	}
	@GetMapping("/work")
	public String work() {
		ModelAndView mav = new ModelAndView();
		List<Blog> blogList = blogRepo.findAll();

		mav.setViewName("services/work");
		return "services/work";
	}
	@GetMapping("/gallery")
	public String gallery() {
		ModelAndView mav = new ModelAndView();
		List<Blog> blogList = blogRepo.findAll();

		mav.setViewName("services/gallery");
		return "services/gallery";
	}
	@GetMapping("/news")
	public String news() {
		ModelAndView mav = new ModelAndView();
		List<Blog> blogList = blogRepo.findAll();

		mav.setViewName("services/news");
		return "services/news";
	}
	@GetMapping("/sign-in")
    public String login() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("services/signIn");
        return "services/signIn";
    }


	@PostMapping("/work/add")
	public String blogAdd(Blog blog) throws IOException {
		ModelAndView mav = new ModelAndView();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nowDate = new Date();
		blog.setWrittenTime(dateFormat.format(nowDate));


		Blog addBlog = blogRepo.save(blog);

		mav.setViewName("index");
		return "index";
	}

}
