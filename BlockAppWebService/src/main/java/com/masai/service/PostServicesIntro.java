package com.masai.service;

import com.masai.entity.Post;
import com.masai.entity.User;

public interface PostServicesIntro {

	public String userRegister(User user);
	public String addPost(Post post, String userId);
	public Post getPostById(int id);
	public java.util.Set<Post> getAllPostByUserId(String userId);
	public String updatePost(Post post);
	public String deletePostById(int id);
	
}
