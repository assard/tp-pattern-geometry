package org.acme.geometry;

public class EnvelopeBuilder implements GeometryVisitor{
	
	private double xmin;
	private double xmax;
	private double ymin;
	private double ymax;
	
	public EnvelopeBuilder() {
		this.xmin = Double.NaN;
		this.xmax = Double.NaN;
		this.ymin = Double.NaN;
		this.ymax = Double.NaN;
	}
	
	public void insert(Coordinate coordinate) {
		if(Double.isNaN(this.xmin)) {
			this.xmin = coordinate.getX();
			this.xmax = coordinate.getX();
			this.ymin = coordinate.getY();
			this.ymax = coordinate.getY();
		}
		else {
			if(coordinate.getX() < this.xmin) {
				this.xmin = coordinate.getX();
			}
			else if(coordinate.getX() > this.xmax) {
				this.xmax = coordinate.getX();
			}
			
			if(coordinate.getY() < this.ymin) {
				this.ymin = coordinate.getY();
			}
			else if(coordinate.getY() > this.ymax) {
				this.ymax = coordinate.getY();
			}
		}
		
		return;
	}
	
	public Envelope build() {
		return new Envelope(
					new Coordinate(this.xmin,this.ymin),
					new Coordinate(this.xmax,this.ymax)
				);
	}
	
	public void visit(Point point) {
		insert(point.getCoordinate());
	}
	
	
	public void visit(LineString lineString) {
		for(int i = 0 ; i < lineString.getNumPoints() ; i++) {
			insert(lineString.getPointN(i).getCoordinate());
		}
	}
	
}
