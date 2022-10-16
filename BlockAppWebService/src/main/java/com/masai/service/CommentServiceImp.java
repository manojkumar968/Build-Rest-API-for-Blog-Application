package com.masai.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.customExceptions.CommentNotExist;
import com.masai.customExceptions.CommentNotFoundInPost;
import com.masai.customExceptions.PostNotExist;
import com.masai.entity.Comment;
import com.masai.entity.Post;
import com.masai.repository.CommentRepo;
import com.masai.repository.PostRepo;

@Service
public class CommentServiceImp implements CommentServiceIntro {

	@Autowired
	PostRepo postRepo;
	
	@Autowired
	CommentRepo commentRepo;
	
	@Override
	public String addComment(Comment comment,int postId) {
		
		Optional<Post> opt=postRepo.findById(postId);
		if(opt.isEmpty()) throw new PostNotExist("Post not Exist by id = "+postId);
		comment.setPost(opt.get());
		commentRepo.save(comment);
		return "comment added into post id = "+postId;
	}

	@Override
	public Comment getCommentbyIdIntoPost(int commentId, int postId) {
		
		Optional<Post>optPost=postRepo.findById(postId);
		if(optPost.isEmpty()) throw new PostNotExist("post not exist by id = "+postId);
		
		Optional<Comment>optComment=commentRepo.findById(commentId);
		if(optComment.isEmpty()) throw new CommentNotExist("comment not exist by id = "+commentId);
		
		if(optComment.get().getPost().getId()!=postId) throw new CommentNotFoundInPost("comment id = "+commentId+" not found in post id = "+postId);
		
		return optComment.get();
	}

	@Override
	public Set<Comment> getAllCommentByPostId(int postId) {

		Optional<Post>opt=postRepo.findById(postId);
		if(opt.isEmpty()) throw new PostNotExist("Post not exist by id = "+postId);
		return opt.get().getComments();
	}

	@Override
	public String updateComment(Comment comment, int postId) {

		Optional<Post>optPost=postRepo.findById(postId);
		if(optPost.isEmpty()) throw new PostNotExist("post not exist by id = "+postId);
		
		Optional<Comment>optComment=commentRepo.findById(comment.getId());
		if(optComment.isEmpty()) throw new CommentNotExist("comment not exist by id = "+comment.getId());
		
		if(optComment.get().getPost().getId()!=postId) throw new CommentNotFoundInPost("comment id = "+comment.getId()+" not found in post id = "+postId);
		
		Comment comment2=optComment.get();
		comment2.setComment(comment.getComment());
		commentRepo.save(comment2);
		
		return "comment updated";
	}

	@Override
	public String deleteComment(int commentId, int postId) {
		Optional<Post>optPost=postRepo.findById(postId);
		if(optPost.isEmpty()) throw new PostNotExist("post not exist by id = "+postId);
		
		Optional<Comment>optComment=commentRepo.findById(commentId);
		if(optComment.isEmpty()) throw new CommentNotExist("comment not exist by id = "+commentId);
		
		if(optComment.get().getPost().getId()!=postId) throw new CommentNotFoundInPost("comment id = "+commentId+" not found in post id = "+postId);
		commentRepo.delete(optComment.get());
		return "comment deleted";
	}

}
