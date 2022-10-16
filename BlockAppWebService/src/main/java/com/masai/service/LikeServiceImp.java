package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.customExceptions.AllreadyLiked;
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
public class LikeServiceImp implements LikeServiceIntro {

	@Autowired
	LikesRepo likesRepo;
	
	@Autowired
	PostRepo postRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	DisLikeRepo disLikeRepo;
	
	@Override
	public String addLike(int postId,String userId) {
		
		Optional<User> optUser=userRepo.findById(userId);
		if(optUser.isEmpty()) throw new NotExist("user not exist by id = "+userId);
		
		Optional<Post> opt=postRepo.findById(postId);
		if(opt.isEmpty()) throw new NotExist("post not exist by id = "+postId);
		
		Optional<Like> optLike=likesRepo.findByUserIdAndPost(userId,opt.get());
		if(optLike.isPresent()) throw new AllreadyLiked("Allready liked not possible to like again ");
		
		Optional<Dislike> optDisLike=disLikeRepo.findByPostAndUserId(opt.get(), userId);
		if(optDisLike.isPresent()) disLikeRepo.delete(optDisLike.get());
		
		Like like = new Like();
		like.setPost(opt.get());
		like.setUserId(userId);
		likesRepo.save(like);
		
		return "Like added";
	}

	@Override
	public String deleteLike(int likeId,int postId) {

		Optional<Like>optLike=likesRepo.findById(likeId);
		if(optLike.isEmpty()) throw new NotExist("like not exist by id = "+likeId);
		if(optLike.get().getPost().getId()!=postId)throw new NotExist("like not exist by id = "+likeId +" and post id = "+postId);
		likesRepo.delete(optLike.get());
		return "like deleted";
	}

}
