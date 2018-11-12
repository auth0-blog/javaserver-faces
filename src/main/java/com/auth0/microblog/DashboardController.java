package com.auth0.microblog;

import com.auth0.microblog.identity.UserSession;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class DashboardController {
  @Inject
  UserSession userSession;

  @Inject
  private MicroPostsService microPostsService;

  private String content;

  public String getUserName() {
    return userSession.getName();
  }

  public String getPicture() {
    return userSession.getPicture();
  }

  public void addMicroPost() {
    microPostsService.addMicroPost(
      new MicroPost(userSession.getId(), userSession.getName(), userSession.getPicture(), content)
    );
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Micro post added successfully.", null);
    FacesContext.getCurrentInstance().addMessage(null, message);
    content = "";
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public List<MicroPost> getMicroPosts() {
    return microPostsService.getMicroPosts(userSession.getId());
  }
}
