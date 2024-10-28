package org.example.springweb.repository;

import org.example.springweb.domain.Post;

import java.util.List;

public interface PostRepository {
  List<Post> findAll();
  Post findById(int postId);
  void deletePost(int postId);
  void updatePost(Post post);
  int insertPost(Post post);
}
