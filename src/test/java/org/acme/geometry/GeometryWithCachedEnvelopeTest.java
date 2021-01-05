package org.acme.geometry;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class GeometryWithCachedEnvelopeTest {

	@Test
	public void testGetEnvelope() {
		//arrange
		Geometry g = SampleFactory.createLineStringOMAE();
		
		// act
		g = new GeometryWithCachedEnvelope(g);
		Envelope a = g.getEnvelope() ; // calcul et stockage dans cachedEnvelope
		Envelope b = g.getEnvelope() ; // renvoi de cachedEnvelope
		
		//assert
		Assert.assertSame(a,b);
		
	}

}
