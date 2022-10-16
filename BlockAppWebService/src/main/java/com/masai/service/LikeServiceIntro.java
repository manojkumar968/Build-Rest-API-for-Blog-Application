package com.masai.service;

public interface LikeServiceIntro {

	public String addLike(int postId,String userId);
	public String deleteLike(int likeId,int postId);
}
