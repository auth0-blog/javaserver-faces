package com.auth0.microblog.identity;

import javax.security.enterprise.CallerPrincipal;

public class Auth0Principal extends CallerPrincipal {
  private String id;
  private String picture;

  Auth0Principal(String id, String name, String picture) {
    super(name);
    this.id = id;
    this.picture = picture;
  }

  public String getId() {
    return id;
  }

  public String getPicture() {
    return picture;
  }
}
