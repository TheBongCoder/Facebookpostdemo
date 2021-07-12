package com.thebongcoder.facebookdemopost.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thebongcoder.facebookdemopost.model.Posts;
import com.thebongcoder.facebookdemopost.repository.PostsRepository;

@Service
public class PostsService {
	
@Autowired
PostsRepository postsRepository;

//getting all posts record by using the method findAll of CrudRepos
public List<Posts>getAllPosts()
{
	List<Posts> posts = new ArrayList<Posts>();
	postsRepository.findAll().forEach(posts1 -> posts.add(posts1));
	return posts;
}

//getting a specific record by using the mtd findById of crudRepo
	public Posts getPostsById(int id)
	{
		return postsRepository.findById(id).get();
	}
	
//saving a specific record by using the method save() of CRUD Repo
	public void saveOrUpdate(Posts posts)
	{
		postsRepository.save(posts);
	}
	
	//delete a specific record by using the method deleteById of CrudRepo
	public void delete(int id)
	{
		postsRepository.deleteById(id);
	}
	
	//updating a record
	public void update(Posts posts,int postid)
	{
		postsRepository.save(posts);
	}
}
