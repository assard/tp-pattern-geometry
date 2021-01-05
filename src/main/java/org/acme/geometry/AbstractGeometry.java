package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry implements Geometry{
	
	private List<GeometryListener> listeners;
	
	public AbstractGeometry() {
		this.listeners = new ArrayList<GeometryListener>();
	}
	
	public abstract Geometry clone();

	public String asText() {
		WktVisitor visitor = new WktVisitor();
		accept(visitor);
		return visitor.getResult();
	}
	
	public Envelope getEnvelope() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		accept(builder);
		return builder.build();
	}
	
	public void addListener(GeometryListener listener) {
		this.listeners.add(listener);
	}
	
	protected void triggerChange() {
		for(GeometryListener listener : this.listeners) {
			listener.onChange(this);
		}
	}
}
