package com.auth0.microblog;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class MicroPostsService implements Serializable {
  private List<MicroPost> microPosts = new ArrayList<>();

  public void addMicroPost(MicroPost microPost) {
    microPosts.add(microPost);
  }

  public List<MicroPost> getMicroPosts() {
    return microPosts;
  }

  public List<MicroPost> getMicroPosts(String userId) {
    return microPosts.stream()
      .filter(microPost -> microPost.getAuthorId().equals(userId))
      .collect(Collectors.toList());
  }

  MicroPostsService() {
    microPosts.add(
      new MicroPost("id123", "Bruno Krebs",
        "https://cdn.auth0.com/blog/profile-picture/bruno-krebs.png",
        "Developing with JavaServer Faces is cool.")
    );

    microPosts.add(
      new MicroPost("id123", "Bruno Krebs",
        "https://cdn.auth0.com/blog/profile-picture/bruno-krebs.png",
        "Java EE and JSF together make a powerful stack.")
    );
  }
}
