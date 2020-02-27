/*******************************************************************************
 * Copyright (c) 2015 Eclipse RDF4J contributors, Aduna, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *******************************************************************************/
package org.eclipse.rdf4j.rio.nquads;

import org.eclipse.rdf4j.rio.AbstractParserHandlingTest;
import org.eclipse.rdf4j.rio.RDFParser;
import org.eclipse.rdf4j.rio.RDFWriter;

import java.io.OutputStream;

/**
 * Test for error handling by N-Quads Parser.
 * 
 * @author Peter Ansell
 */
public class NQuadsHandlingTest extends AbstractParserHandlingTest {
	@Override
	protected RDFParser getParser() {
		return new NQuadsParser();
	}

	@Override
	protected RDFWriter createWriter(OutputStream output) {
		return new NQuadsWriter(output);
	}
}
