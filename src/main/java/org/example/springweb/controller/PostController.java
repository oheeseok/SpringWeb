package org.example.springweb.controller;

import org.apache.ibatis.annotations.Param;
import org.example.springweb.domain.*;
import org.example.springweb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

  private final PostService postService;

  // 생성자 DI 주입
  @Autowired
  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/posts")
  public List<PostAllResponseDto> viewAllPosts(@RequestParam(name = "likes", required = false) Integer likes,
                                               @RequestParam(name = "title", required = false) String title) {
    if (likes != null || title != null) {
      return postService.getAllPostsWithLikes(likes, title);
    } else {
      return postService.getAllPosts();
    }
  }

//  @GetMapping("/posts")
//  public List<PostAllResponseDto> viewAllPosts() {
//    return postService.getAllPosts();
//  }


  @GetMapping("/posts/{postId}")
  public PostDetailResponseDto viewPostDetail(@PathVariable("postId") int postId) {
    return postService.getPostDetail(postId);
  }

  @PostMapping("/posts")
  public PostDetailResponseDto createNewPost(@RequestBody PostCreateRequestDto postCreateRequestDto) {
    return postService.createPost(postCreateRequestDto);
  }

  @DeleteMapping("/posts/{postId}")
  public void deletePost(@PathVariable("postId") int postId) {
    postService.deletePost(postId);
  }

  @PutMapping("/posts/{postId}")
  public int updateLikesPost(@PathVariable("postId") int postId) {
    return postService.increaseLikes(postId);
  }

  @PatchMapping("/posts/{postId}")
  public PostDetailResponseDto updateBodyPost(@PathVariable("postId") int postId,
                                              @RequestBody PostUpdateRequestDto postDto) {
    return postService.updatePost(postId, postDto);
  }

}
