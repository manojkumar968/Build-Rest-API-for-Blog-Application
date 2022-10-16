package com.masai.controller;

import java.util.Set;

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

import com.masai.entity.Comment;
import com.masai.helperClasses.ResponceBody;
import com.masai.service.CommentServiceImp;

@RestController
@RequestMapping("comment")
public class CommentResourse {

	@Autowired
	CommentServiceImp commentServiceImp;

	@PostMapping("/{postid}")
	public ResponseEntity<ResponceBody> addComment(@RequestBody Comment comment, @PathVariable int postid) {

		String res = commentServiceImp.addComment(comment, postid);

		ResponceBody rsBody = new ResponceBody();
		rsBody.setDescription(res);

		return new ResponseEntity<ResponceBody>(rsBody, HttpStatus.OK);
	}

	@GetMapping("/post/{postId}/comment/{commentId}")
	public ResponseEntity<Comment> getComment(@PathVariable int postId, @PathVariable int commentId) {

		Comment res = commentServiceImp.getCommentbyIdIntoPost(commentId, postId);

		return new ResponseEntity<Comment>(res, HttpStatus.OK);
	}

	@GetMapping("/getAllComments/{postId}")
	public ResponseEntity<Set<Comment>> getAllCommentByPostId(@PathVariable int postId) {

		Set<Comment> res = commentServiceImp.getAllCommentByPostId(postId);

		return new ResponseEntity<Set<Comment>>(res, HttpStatus.OK);
	}
	
	
	@PutMapping("/{postid}")
	public ResponseEntity<ResponceBody> updateComment(@RequestBody Comment comment, @PathVariable int postid) {

		String res = commentServiceImp.updateComment(comment, postid);

		ResponceBody rsBody = new ResponceBody();
		rsBody.setDescription(res);

		return new ResponseEntity<ResponceBody>(rsBody, HttpStatus.OK);
	}
	
	@DeleteMapping("/post/{postId}/comment/{commentId}")
	public ResponseEntity<ResponceBody> deleteComment(@PathVariable int postId, @PathVariable int commentId) {

		String res = commentServiceImp.deleteComment(commentId, postId);
		ResponceBody responceBody=new ResponceBody();
		responceBody.setDescription(res);
		return new ResponseEntity<ResponceBody>(responceBody, HttpStatus.OK);
	}

}
