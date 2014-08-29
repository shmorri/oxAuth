package org.xdi.oxauth.session.ws.rs;

import com.wordnik.swagger.annotations.Api;
import org.xdi.oxauth.model.session.EndSessionRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 * @author Javier Rojas Date: 12.15.2011
 */
@Path("/oxauth")
@Api(value = "/oxauth", description = "End Session Endpoint - URL at the OP to which an RP can perform a redirect to request that the End-User be logged out at the OP")
public interface EndSessionRestWebService {

    @GET
    @Path("/end_session")
    @Produces({MediaType.TEXT_PLAIN})
    Response requestEndSession(
            @QueryParam(EndSessionRequestParam.ID_TOKEN_HINT) String idTokenHint,
            @QueryParam(EndSessionRequestParam.POST_LOGOUT_REDIRECT_URI) String postLogoutRedirectUri,
            @QueryParam("session_id") String sessionId,
            @Context HttpServletRequest httpRequest,
            @Context HttpServletResponse httpResponse,
            @Context SecurityContext securityContext);
}