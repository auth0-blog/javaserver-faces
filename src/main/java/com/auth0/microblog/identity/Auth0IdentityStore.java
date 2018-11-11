package com.auth0.microblog.identity;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;

@ApplicationScoped
public class Auth0IdentityStore implements IdentityStore {

  @Override
  public CredentialValidationResult validate(final Credential credential) {
    CredentialValidationResult result = CredentialValidationResult.NOT_VALIDATED_RESULT;
    if (credential instanceof Auth0JwtCredential) {
      Auth0JwtCredential jwtCredential = (Auth0JwtCredential) credential;
      result = new CredentialValidationResult(jwtCredential.getAuth0Principal());
    }
    return result;
  }
}
