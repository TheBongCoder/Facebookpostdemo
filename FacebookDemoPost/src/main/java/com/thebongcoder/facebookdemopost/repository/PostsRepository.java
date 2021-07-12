package com.thebongcoder.facebookdemopost.repository;

import org.springframework.data.repository.CrudRepository;
import com.thebongcoder.facebookdemopost.model.Posts;


public interface PostsRepository extends CrudRepository<Posts, Integer> 
{

}
