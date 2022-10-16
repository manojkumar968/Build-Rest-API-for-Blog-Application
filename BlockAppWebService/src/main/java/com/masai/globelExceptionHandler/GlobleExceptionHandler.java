package com.masai.globelExceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.masai.customExceptions.AllreadyDislike;
import com.masai.customExceptions.AllreadyLiked;
import com.masai.customExceptions.CommentNotExist;
import com.masai.customExceptions.CommentNotFoundInPost;
import com.masai.customExceptions.NotExist;
import com.masai.customExceptions.PostNotExist;
import com.masai.customExceptions.UserAllreadyRegisterd;
import com.masai.customExceptions.UserNotRegisterd;
import com.masai.helperClasses.MyError;

@ControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(UserAllreadyRegisterd.class)
	public ResponseEntity<MyError> userRegisterd(UserAllreadyRegisterd err,WebRequest web){
		
		MyError myError=new MyError();
		myError.setLocalDateTime(LocalDateTime.now());
		myError.setMsg(err.getMessage());
		myError.setDescription(web.getDescription(false));
		
		return new ResponseEntity<MyError>(myError,HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	@ExceptionHandler(UserNotRegisterd.class)
	public ResponseEntity<MyError> userRegisterd(UserNotRegisterd err,WebRequest web){
		
		MyError myError=new MyError();
		myError.setLocalDateTime(LocalDateTime.now());
		myError.setMsg(err.getMessage());
		myError.setDescription(web.getDescription(false));
		
		return new ResponseEntity<MyError>(myError,HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	@ExceptionHandler(PostNotExist.class)
	public ResponseEntity<MyError> userRegisterd(PostNotExist err,WebRequest web){
		
		MyError myError=new MyError();
		myError.setLocalDateTime(LocalDateTime.now());
		myError.setMsg(err.getMessage());
		myError.setDescription(web.getDescription(false));
		
		return new ResponseEntity<MyError>(myError,HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	@ExceptionHandler(CommentNotExist.class)
	public ResponseEntity<MyError> userRegisterd(CommentNotExist err,WebRequest web){
		
		MyError myError=new MyError();
		myError.setLocalDateTime(LocalDateTime.now());
		myError.setMsg(err.getMessage());
		myError.setDescription(web.getDescription(false));
		
		return new ResponseEntity<MyError>(myError,HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	@ExceptionHandler(CommentNotFoundInPost.class)
	public ResponseEntity<MyError> userRegisterd(CommentNotFoundInPost err,WebRequest web){
		
		MyError myError=new MyError();
		myError.setLocalDateTime(LocalDateTime.now());
		myError.setMsg(err.getMessage());
		myError.setDescription(web.getDescription(false));
		
		return new ResponseEntity<MyError>(myError,HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	@ExceptionHandler(NotExist.class)
	public ResponseEntity<MyError> userRegisterd(NotExist err,WebRequest web){
		
		MyError myError=new MyError();
		myError.setLocalDateTime(LocalDateTime.now());
		myError.setMsg(err.getMessage());
		myError.setDescription(web.getDescription(false));
		
		return new ResponseEntity<MyError>(myError,HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	@ExceptionHandler(AllreadyLiked.class)
	public ResponseEntity<MyError> userRegisterd(AllreadyLiked err,WebRequest web){
		
		MyError myError=new MyError();
		myError.setLocalDateTime(LocalDateTime.now());
		myError.setMsg(err.getMessage());
		myError.setDescription(web.getDescription(false));
		
		return new ResponseEntity<MyError>(myError,HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(AllreadyDislike.class)
	public ResponseEntity<MyError> userRegisterd(AllreadyDislike err,WebRequest web){
		
		MyError myError=new MyError();
		myError.setLocalDateTime(LocalDateTime.now());
		myError.setMsg(err.getMessage());
		myError.setDescription(web.getDescription(false));
		
		return new ResponseEntity<MyError>(myError,HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyError> userRegisterd(MethodArgumentNotValidException err,WebRequest web){
		
		MyError myError=new MyError();
		myError.setLocalDateTime(LocalDateTime.now());
		myError.setMsg(err.getBindingResult().getFieldError().getDefaultMessage());
		myError.setDescription(web.getDescription(false));
		
		return new ResponseEntity<MyError>(myError,HttpStatus.NOT_ACCEPTABLE);
	}
	
}
