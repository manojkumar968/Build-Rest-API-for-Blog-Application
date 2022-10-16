package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.customExceptions.AllreadyDislike;
import com.masai.customExceptions.NotExist;
import com.masai.entity.Dislike;
import com.masai.entity.Like;
import com.masai.entity.Post;
import com.masai.entity.User;
import com.masai.repository.DisLikeRepo;
import com.masai.repository.LikesRepo;
import com.masai.repository.PostRepo;
import com.masai.repository.UserRepo;

@Service
public class DisLikeServiceImp implements DisLikeServiceIntro {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PostRepo postRepo;
	
	@Autowired
	DisLikeRepo disLikeRepo;
	
	@Autowired
	LikesRepo likesRepo;
	
	@Override
	public String addDisLike(int postId, String userId) {

	Optional<User> optUser=userRepo.findById(userId);
	if(optUser.isEmpty()) throw new NotExist("User not Exist by id = "+userId);
	
	Optional<Post> optPost=postRepo.findById(postId);
	if(optPost.isEmpty()) throw new NotExist("post not exist by id = "+postId);
	
	Optional<Dislike> optDisLike=disLikeRepo.findByPostAndUserId(optPost.get(), userId);
	if(optDisLike.isPresent()) throw new AllreadyDislike("Allready Disliked not dislike again");	
		
	Optional<Like> optLike=likesRepo.findByUserIdAndPost(userId, optPost.get());
	if(optLike.isPresent()) likesRepo.delete(optLike.get());
	
	Dislike dislike = new Dislike();
	dislike.setPost(optPost.get());
	dislike.setUserId(userId);
	disLikeRepo.save(dislike);
	
	return "added dislike";
	}

	@Override
	public String deleteDislike(int dislikeId, int postId) {

		Optional<Dislike>optDislike=disLikeRepo.findById(dislikeId);
		if(optDislike.isEmpty()) throw new NotExist("Dislike not exist by id = "+dislikeId);
		if(optDislike.get().getPost().getId()!=postId) throw new NotExist("Dislike not exist by id = "+dislikeId+" and post id = "+postId);
		disLikeRepo.delete(optDislike.get());
		return "Dislike deleted";
	}

}
