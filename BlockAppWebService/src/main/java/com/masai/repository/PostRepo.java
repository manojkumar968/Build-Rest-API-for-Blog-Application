package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Post;

public interface PostRepo extends JpaRepository<Post, Integer>{

}
