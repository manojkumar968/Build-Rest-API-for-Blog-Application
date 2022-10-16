package com.masai.service;

public interface DisLikeServiceIntro {

	public String addDisLike(int postId,String userId);
	public String deleteDislike(int dislikeId, int postId);
}
