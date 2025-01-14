package org.example.springweb.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.springweb.domain.Post;

import java.util.List;

//@Mapper
public interface PostRepository {
  @Select("select * from post")
  List<Post> findAll();
  List<Post> findAllWithLikes(@Param("likes") Integer likes, @Param("title") String title);
  Post findById(int postId);
  void deletePost(int postId);
  void updatePost(Post post);
  int insertPost(Post post);
}
