package com.masai.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String imageURL;
	private String msg;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "post", orphanRemoval = true)
	private Set<Like> likes= new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "post",orphanRemoval = true)
	private Set<Dislike> dislikes = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "post", orphanRemoval = true)
	private Set<Comment> comments = new HashSet<>();
	
	@ManyToOne
	@JsonIgnore
	private User user;
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Set<Like> getLikes() {
		return likes;
	}



	public Set<Dislike> getDislikes() {
		return dislikes;
	}



	public Set<Comment> getComments() {
		return comments;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", imageURL=" + imageURL + ", msg=" + msg + ", likes=" + likes + ", dislikes="
				+ dislikes + ", comments=" + comments + ", user=" + user + "]";
	}


	
	
	
}
