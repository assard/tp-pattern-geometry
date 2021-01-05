package org.acme.geometry;

public class Point extends AbstractGeometry{
	private Coordinate coordinate;
	
	private final String TYPE = "Point"; 
	
	public String getType() {
		return TYPE;
	} 
	
	public Point() {
		this.coordinate = new Coordinate();
	}
	
	public Point(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public Coordinate getCoordinate() {
		return this.coordinate;
	}
	
	public boolean isEmpty() {
		return this.coordinate.isEmpty();
	}
	
	public void translate(double dx, double dy) {
		
		this.coordinate = new Coordinate(
				this.getCoordinate().getX()+dx,
				this.getCoordinate().getY()+dy
				);
		
		return;
	}
	
	@Override
	public Point clone() {
		return new Point (new Coordinate(this.coordinate.getX(),this.coordinate.getY()));
	}
	
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}
}
