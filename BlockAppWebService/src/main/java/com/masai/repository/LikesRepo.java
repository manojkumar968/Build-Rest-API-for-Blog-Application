package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Like;
import com.masai.entity.Post;

public interface LikesRepo extends JpaRepository<Like, Integer> {

	public Optional<Like> findByPost(Post post);
	public Optional<Like> findByUserIdAndPost(String userId,Post post);
	
}
