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
import com.masai.service.DisLikeServiceImp;

@RestController
@RequestMapping("dislike")
public class DislikeResource {

	@Autowired
	DisLikeServiceImp disLikeServiceImp;
	
	@PostMapping("/{postId}/{userId}")
	public ResponseEntity<ResponceBody> addDislike(@PathVariable int postId,@PathVariable String userId){
		
		String msg=disLikeServiceImp.addDisLike(postId, userId);
		
		ResponceBody responceBody = new ResponceBody();
		responceBody.setDescription(msg);
		
		return new ResponseEntity<ResponceBody>(responceBody,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteDislike/{dislikeId}/{postId}")
	public ResponseEntity<ResponceBody> deleteDislike(@PathVariable int dislikeId,@PathVariable int postId){
		
		String msg=disLikeServiceImp.deleteDislike(dislikeId, postId);
		
		ResponceBody responceBody = new ResponceBody();
		responceBody.setDescription(msg);
		
		return new ResponseEntity<ResponceBody>(responceBody,HttpStatus.OK);
	}
	
}
