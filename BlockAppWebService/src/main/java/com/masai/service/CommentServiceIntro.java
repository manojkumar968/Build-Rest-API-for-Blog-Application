package com.masai.service;

import java.util.Set;

import com.masai.entity.Comment;

public interface CommentServiceIntro {

	public String addComment(Comment comment,int postId);
	public Comment getCommentbyIdIntoPost(int commentId, int postId);
	public Set<Comment> getAllCommentByPostId(int postId);
	public String updateComment(Comment comment,int postId);
	public String deleteComment(int commentId, int postId);
}
