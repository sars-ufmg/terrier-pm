/*
 * Terrier - Terabyte Retriever 
 * Webpage: http://terrier.org 
 * Contact: terrier{a.}dcs.gla.ac.uk
 * University of Glasgow - School of Computing Science
 * http://www.gla.ac.uk/
 * 
 * The contents of this file are subject to the Mozilla Public License
 * Version 1.1 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See
 * the License for the specific language governing rights and limitations
 * under the License.
 *
 * The Original is in 'TestTRECQrelsInMemory.java'
 *
 * The Original Code is Copyright (C) 2004-2020 the University of Glasgow.
 * All Rights Reserved.
 *
 * Contributor(s):
 *   Craig Macdonald <craigm{a.}dcs.gla.ac.uk>
 *   Richard McCreadie <richard.mccreadie@glasgow.ac.uk>
 */
package org.terrier.evaluation;

import static org.junit.Assert.*;

import org.junit.Test;
import org.terrier.tests.ApplicationSetupBasedTest;

public class TestTRECQrelsInMemory extends ApplicationSetupBasedTest {

	@Test public void testRelevant() throws Exception
	{
		String filename = super.writeTemporaryFile("test.qrels", 
			new String[]{
				"1 0 doc1 1",
				"1 0 doc2 0",
				"1 0 doc3 2",
				"1 0 doc4 -2"});
		TRECQrelsInMemory qrels = new TRECQrelsInMemory(filename);
		assertEquals(2, qrels.getNumberOfRelevant("1"));
		assertTrue(qrels.isRelevant("1", "doc1"));
		assertFalse(qrels.isRelevant("1", "doc2"));
		assertTrue(qrels.isRelevant("1", "doc3"));
		assertFalse(qrels.isRelevant("1", "doc4"));
		
	}
	
}
