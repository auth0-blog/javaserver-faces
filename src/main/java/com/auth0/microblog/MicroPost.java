package com.auth0.microblog;

public class MicroPost {
  private String authorId;
  private String author;
  private String authorPicture;
  private String content;

  public MicroPost(String authorId, String author, String authorPicture, String content) {
    this.authorId = authorId;
    this.author = author;
    this.authorPicture = authorPicture;
    this.content = content;
  }

  public String getAuthorId() {
    return authorId;
  }

  public String getAuthor() {
    return author;
  }

  public String getAuthorPicture() {
    return authorPicture;
  }

  public String getContent() {
    return content;
  }
}
