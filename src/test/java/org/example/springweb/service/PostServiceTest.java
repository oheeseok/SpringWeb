package org.example.springweb.service;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

  @BeforeAll
  static void init() {
    System.out.println("init");
  }

  @BeforeEach
  void setUp() {
    System.out.println("메소드 실행 전");
  }

  @AfterEach
  void tearDown() {
    System.out.println("메소드 실행 후");
  }

  @Test
  void getAllPosts() {
    System.out.println("모든 게시판 글 목록 조회");
  }

  @Test
  void getPostDetail() {
    System.out.println("게시판 글 조회");
  }
}