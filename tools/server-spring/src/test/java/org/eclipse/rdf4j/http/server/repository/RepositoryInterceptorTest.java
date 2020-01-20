/*******************************************************************************
 * Copyright (c) 2020 Eclipse RDF4J contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *******************************************************************************/
package org.eclipse.rdf4j.http.server.repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

public class RepositoryInterceptorTest {

	private RepositoryInterceptor subject;
	private HttpServletRequest request;
	private HttpServletResponse response;

	private String repositoryID = "test";

	@Before
	public void setUp() throws Exception {
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);

		subject = new RepositoryInterceptor();
	}

	@Test
	public void testPreHandleOnRepositoryDelete() throws Exception {
		when(request.getPathInfo()).thenReturn("/" + repositoryID);
		when(request.getMethod()).thenReturn("DELETE");

		subject.preHandle(request, response, null);

		verify(request).setAttribute(eq("repositoryID"), eq(repositoryID));
		verify(request, never()).setAttribute(eq("repository"), any());
	}

}
