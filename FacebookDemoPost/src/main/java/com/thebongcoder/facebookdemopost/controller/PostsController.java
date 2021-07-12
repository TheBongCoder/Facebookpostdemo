package com.thebongcoder.facebookdemopost.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thebongcoder.facebookdemopost.model.Posts;
import com.thebongcoder.facebookdemopost.service.PostsService;

@RestController

public class PostsController 
{
	@Autowired
	PostsService postsService;
	
	//creating a get mapping that retrives all the posts details from the DB
	
	@GetMapping("/post")
	private List<Posts> getAllPosts()
	{
		return postsService.getAllPosts();
	}
	
	//retriving a detail of a specific post
	
	@GetMapping("/post/{postid}")
	private Posts getPosts(@PathVariable("postid") int postid)
	{
		return postsService.getPostsById(postid);
	}
	
	//creating a delete mapping that deletes a specified post
	
	@DeleteMapping("/post/{postid}")
	private void deletePost(@PathVariable ("postid") int postid)
	{
		postsService.delete(postid);
	}
	
	//creating a post in the DB
	
	@PostMapping("/posts")
	private int savePost(@RequestBody Posts posts)
	{
		postsService.saveOrUpdate(posts);
		return posts.getPostid();
	}
	
	@PutMapping("/posts")
	private Posts update(@RequestBody Posts posts)
	{
		postsService.saveOrUpdate(posts);
		return posts;
	}
	
}
