package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.helperClasses.ResponceBody;
import com.masai.service.LikeServiceImp;

@RestController
@RequestMapping("like")
public class LikeResourse {

	@Autowired
	LikeServiceImp likeServiceImp;
	
	
	@PostMapping("/{postId}/{userId}")
	public ResponseEntity<ResponceBody> addLike(@PathVariable int postId,@PathVariable String userId){
		
		String res=likeServiceImp.addLike(postId, userId);
		ResponceBody responceBody = new ResponceBody();
		responceBody.setDescription(res);
		
		return new ResponseEntity<ResponceBody>(responceBody,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteLike/{likeId}/{postId}")
	public ResponseEntity<ResponceBody> deleteLike(@PathVariable int likeId,@PathVariable int postId){
		
		String res=likeServiceImp.deleteLike(likeId, postId);
		ResponceBody responceBody = new ResponceBody();
		responceBody.setDescription(res);
		
		return new ResponseEntity<ResponceBody>(responceBody,HttpStatus.OK);
		
	}
	
	
}
