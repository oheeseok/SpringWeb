package org.example.springweb.service;

import lombok.extern.slf4j.Slf4j;
import org.example.springweb.domain.*;
import org.example.springweb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PostService {

  private final PostRepository postRepository;

  @Autowired
  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public List<PostAllResponseDto> getAllPosts() {
    List<Post> allPosts = postRepository.findAll();
    List<PostAllResponseDto> postDtos = allPosts.stream()
        .map(PostAllResponseDto::of)
        .collect(Collectors.toList());
    return postDtos;
  }

  public List<PostAllResponseDto> getAllPostsWithLikes(Integer likes, String title) {
    List<Post> allPosts = postRepository.findAllWithLikes(likes, title);
    List<PostAllResponseDto> postDtos = allPosts.stream()
        .map(PostAllResponseDto::of)
        .collect(Collectors.toList());
    return postDtos;
  }

  public PostDetailResponseDto getPostDetail(int postId) {
    Post post = postRepository.findById(postId);
    if (post == null) {
     return null;
    }
    PostDetailResponseDto retPost = new PostDetailResponseDto(
        post.getPostId(),
        post.getTitle(),
        post.getBody(),
        post.getLikes()
    );
    return retPost;
  }

  public PostDetailResponseDto createPost(PostCreateRequestDto postCreateRequestDto) {
    Post post = new Post(
        0,
        postCreateRequestDto.getTitle(),
        postCreateRequestDto.getBody(),
        0
    );

    log.info("+++++ post: {}", post);

    postRepository.insertPost(post); // 성공시 1, 실패시 0
    return getPostDetail(post.getPostId());
  }

  public void deletePost(int postId) {
    postRepository.deletePost(postId);
  }

  public int increaseLikes(int postId) {
    Post post = postRepository.findById(postId);
    int likes = 0;
    if (post != null) {
      likes = post.getLikes() + 1;
      post.setLikes(likes);
    }
    postRepository.updatePost(post);
    return likes;
  }

  public PostDetailResponseDto updatePost(int postId, PostUpdateRequestDto postDto) {
    Post post = postRepository.findById(postId);
    // body는 빈 내용을 허용하지 않는다.

    if(post != null && !postDto.getBody().equals("")) {
      post.setBody(postDto.getBody());
      postRepository.updatePost(post);
    }
    return getPostDetail(postId);
  }


}
