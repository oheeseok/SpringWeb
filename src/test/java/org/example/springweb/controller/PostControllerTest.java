package org.example.springweb.controller;

import org.example.springweb.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@Component
class PostControllerTest {
  PostController postController;

  void PostControllerTest(PostController postController) {
    this.postController = postController;
  }

  @Test
  public void testPostController() {

  }
}