package com.masai.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.customExceptions.PostNotExist;
import com.masai.customExceptions.UserAllreadyRegisterd;
import com.masai.customExceptions.UserNotRegisterd;
import com.masai.entity.Post;
import com.masai.entity.User;
import com.masai.repository.PostRepo;
import com.masai.repository.UserRepo;

@Service
public class PostServiceImp implements PostServicesIntro {

	@Autowired
	UserRepo userRepo;
	@Autowired
	PostRepo postRepo;
	
	@Override
	public String userRegister(User user) {
		
		Optional<User> opt=userRepo.findById(user.getPhone());
		if(!opt.isEmpty()) throw new UserAllreadyRegisterd("User all ready registerd");
		
		userRepo.save(user);
		
		return "user registerd";
	}
	@Override
	public String addPost(Post post, String userId) {
		
		Optional<User> opt=userRepo.findById(userId);
		if(opt.isEmpty()) throw new UserNotRegisterd("user not registerd by "+userId);
		
		User user = opt.get();
		user.getPosts().add(post);
		
		post.setUser(user);
		
		postRepo.save(post);
		
		
		userRepo.save(user);
		return "post created";
	}
	@Override
	public Post getPostById(int id) {
		
		Optional<Post> opt=postRepo.findById(id);
		if(opt.isEmpty()) throw new PostNotExist("post not exist by "+id);
		return opt.get();
	}
	@Override
	public Set<Post> getAllPostByUserId(String userId) {

		Optional<User> opt=userRepo.findById(userId);
		if(opt.isEmpty()) throw new UserNotRegisterd("user not fund by "+userId);
		
		return opt.get().getPosts();
	}
	@Override
	public String updatePost(Post post) {
		
		Optional<Post> opt=postRepo.findById(post.getId());
		if(opt.isEmpty()) throw new PostNotExist("post not exist by id = "+post.getId());
		Post post2 = opt.get();
		post2.setImageURL(post.getImageURL());
		post2.setMsg(post.getMsg());
		postRepo.save(post2);
		
		return "post updated";
	}
	@Override
	public String deletePostById(int id) {

		Optional<Post> opt=postRepo.findById(id);
		if(opt.isEmpty()) throw new PostNotExist("post not exist by id = "+id);
		postRepo.delete(opt.get());
		return "post deleted";
	}

	
}
