package com.auth0.microblog;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

@ApplicationPath("/")
@Path("/message")
public class MicroblogApplication extends Application {
  @GET
  @Produces("text/plain")
  public Response doGet() {
    return Response.ok("Hello from Thorntail!").build();
  }
}
