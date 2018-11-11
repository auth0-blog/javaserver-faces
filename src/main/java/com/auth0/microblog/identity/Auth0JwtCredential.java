package com.auth0.microblog.identity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.security.enterprise.credential.Credential;

class Auth0JwtCredential implements Credential {
  private final Auth0Principal auth0Principal;

  Auth0JwtCredential(final String token) {
    DecodedJWT jwt = JWT.decode(token);
    String userId = jwt.getClaim("sub").asString();
    String name = jwt.getClaim("name").asString();
    String picture = jwt.getClaim("picture").asString();
    this.auth0Principal = new Auth0Principal(userId, name, picture);
  }

  Auth0Principal getAuth0Principal() {
    return auth0Principal;
  }
}
