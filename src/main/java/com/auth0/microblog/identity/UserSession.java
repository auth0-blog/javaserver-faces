package com.auth0.microblog.identity;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;
import java.io.Serializable;

@Named
@SessionScoped
public class UserSession implements Serializable {
  @Inject
  SecurityContext securityContext;

  public boolean isLoggedIn() {
    return securityContext.getCallerPrincipal() != null;
  }

  public String getId() {
    return getPrincipal().getId();
  }

  public String getName() {
    return getPrincipal().getName();
  }

  public String getPicture() {
    return getPrincipal().getPicture();
  }

  public String logout() {
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    return "/?faces-redirect=true";
  }

  private Auth0Principal getPrincipal() {
    return (Auth0Principal) securityContext.getCallerPrincipal();
  }
}
