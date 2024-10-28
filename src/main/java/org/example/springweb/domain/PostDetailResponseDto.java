package org.example.springweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostDetailResponseDto {
  private int postId;
  private String title;
  private String body;
  private int likes;
}
