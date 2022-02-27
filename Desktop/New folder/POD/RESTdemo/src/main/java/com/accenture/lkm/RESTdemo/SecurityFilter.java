package com.accenture.lkm.RESTdemo;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.commons.codec.binary.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if(requestContext.getUriInfo().getPath().contains("students"))
		{
		List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);

		if (authHeader != null && authHeader.size() > 0) {
			String authToken = authHeader.get(0);
			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
			byte[] decodeBase64 = Base64.decodeBase64(authToken);
			String decodedToken = new String(decodeBase64, "UTF-8");
			StringTokenizer tokenier = new StringTokenizer(decodedToken, ":");
			String userName = tokenier.nextToken();
			String password = tokenier.nextToken();

			if ("user123".equals(userName) && "password123".equals(password)) {
				return;
			}

		}
		Response unAuthstatus = Response
									.status(Response.Status.UNAUTHORIZED)
									.entity("User cannot access the resource")
									.build();
		requestContext.abortWith(unAuthstatus);
	}

}
}
