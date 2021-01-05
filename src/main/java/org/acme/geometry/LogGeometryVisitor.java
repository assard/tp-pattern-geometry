package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor{
	
	private PrintStream out;
	
	public LogGeometryVisitor() {
		
	}
	
	public LogGeometryVisitor(PrintStream out) {
		this.out = out;
	}
	
	public void visit(Point point) {
		
		System.out.println("Je suis un point avec x=" + point.getCoordinate().getX() + " et y="+ point.getCoordinate().getY());
		
		return;
	}
	
	public void visit(LineString lineString) {
		
		System.out.println("Je suis une polyligne définie par"+ lineString.getNumPoints() + "point(s)");
		
		return;
	}
	
}
