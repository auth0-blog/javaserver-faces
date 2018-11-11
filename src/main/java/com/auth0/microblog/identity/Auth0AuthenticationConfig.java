package com.auth0.microblog.identity;

import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class Auth0AuthenticationConfig {

  @Inject
  @ConfigurationValue("auth0.domain")
  private String domain;

  @Inject
  @ConfigurationValue("auth0.clientId")
  private String clientId;

  @Inject
  @ConfigurationValue("auth0.clientSecret")
  private String clientSecret;

  @Inject
  @ConfigurationValue("auth0.scope")
  private String scope;

  @Inject
  @ConfigurationValue("auth0.callbackUri")
  private String callbackUri;

  public String getDomain() {
    return domain;
  }

  public String getClientId() {
    return clientId;
  }

  public String getClientSecret() {
    return clientSecret;
  }

  public String getScope() {
    return scope;
  }

  public String getCallbackUri() {
    return callbackUri;
  }
}
