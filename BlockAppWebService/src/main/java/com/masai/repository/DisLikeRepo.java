package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Dislike;
import com.masai.entity.Post;

public interface DisLikeRepo extends JpaRepository<Dislike, Integer>{

	public Optional<Dislike> findByPostAndUserId(Post post, String userId);
	
}
