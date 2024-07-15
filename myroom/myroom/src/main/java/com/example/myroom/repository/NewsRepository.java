package com.example.myroom.repository;

import com.example.myroom.dto.Blog;
import com.example.myroom.dto.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News,Long>{

}
