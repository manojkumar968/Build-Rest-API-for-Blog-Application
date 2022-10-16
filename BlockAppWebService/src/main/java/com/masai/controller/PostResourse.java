package com.masai.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Post;
import com.masai.entity.User;
import com.masai.helperClasses.ResponceBody;
import com.masai.service.PostServiceImp;

@RestController
@RequestMapping("api")
public class PostResourse {

	@Autowired
	PostServiceImp blkSerImp;
	
	@PostMapping("/register")
	public ResponseEntity<ResponceBody> registerdUser(@Valid @RequestBody User ur){
		
		String res=blkSerImp.userRegister(ur);
		
		ResponceBody rsBody = new ResponceBody();
		rsBody.setDescription(res);
		
		return new  ResponseEntity<ResponceBody>(rsBody,HttpStatus.OK);
	}
	
	
	
	@PostMapping("/post/{userid}")
	public ResponseEntity<ResponceBody> postCreat(@RequestBody Post post,@PathVariable String userid){
		
		String res=blkSerImp.addPost(post, userid);
		
		ResponceBody rsBody = new ResponceBody();
		rsBody.setDescription(res);
		
		return new  ResponseEntity<ResponceBody>(rsBody,HttpStatus.OK);
	}
	
	
	@GetMapping("/getpost/{postid}")
	public ResponseEntity<Post> getPost(@PathVariable int postid){
		
		Post res=blkSerImp.getPostById(postid);

		return new  ResponseEntity<Post>(res,HttpStatus.OK);
	}
	
	@GetMapping("/getallpost/{userid}")
	public ResponseEntity<Set<Post>> getPost(@PathVariable String userid){
		
		Set<Post> res=blkSerImp.getAllPostByUserId(userid);

		return new  ResponseEntity<Set<Post>>(res,HttpStatus.OK);
	}
	
	
	@PutMapping("/updatepost")
	public ResponseEntity<ResponceBody> postCreat(@RequestBody Post post){
		
		String res=blkSerImp.updatePost(post);
		
		ResponceBody rsBody = new ResponceBody();
		rsBody.setDescription(res);
		
		return new  ResponseEntity<ResponceBody>(rsBody,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deletepost/{postId}")
	public ResponseEntity<ResponceBody> postCreat(@ PathVariable int postId){
		
		String res=blkSerImp.deletePostById(postId);
		
		ResponceBody rsBody = new ResponceBody();
		rsBody.setDescription(res);
		
		return new  ResponseEntity<ResponceBody>(rsBody,HttpStatus.OK);
	}
	
}
