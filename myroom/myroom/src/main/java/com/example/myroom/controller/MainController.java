package com.example.myroom.controller;

import com.example.myroom.dto.Blog;
import com.example.myroom.repository.BlogRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

		response.setContentType("text/html;charset=UTF-8");
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nowDate = new Date();
		blog.setWrittenTime(dateFormat.format(nowDate));

		if (!file.isEmpty()) {
			String filePath = "/Users/hee/Documents/project/portfolio/myroom/myroom/src/main/webapp/assets/img/work/" + file.getOriginalFilename();
			System.out.println("fileName is = " + blog.getId());
			System.out.println("filePath is = " + filePath);
			blog.setFileName(file.getOriginalFilename());
			file.transferTo(new File(filePath));
			blog.setFileUrl("/assets/img/work/" + file.getOriginalFilename());
			Blog addBlog = blogRepo.save(blog);
		}


		mav.setViewName("index");
		return mav;
	}

}
