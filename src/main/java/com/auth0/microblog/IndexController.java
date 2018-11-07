package com.auth0.microblog;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class IndexController {
  @Inject
  private MicroPostsService microPostsService;

  public List<MicroPost> getMicroPosts() {
    return microPostsService.getMicroPosts();
  }
}
