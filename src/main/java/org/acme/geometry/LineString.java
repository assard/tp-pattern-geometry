package org.acme.geometry;
import java.util.ArrayList;
import java.util.List;

public class LineString extends AbstractGeometry{
	
	private List<Point> points;
	private final String TYPE = "LineString";
	
	public LineString() {
		this.points = new ArrayList<Point>();
	}
	
	public LineString(List<Point> points) {
		assert(points != null);
		this.points = points;
	}
	
	public int getNumPoints() {
		return this.points.size();
	}
	
	public Point getPointN(int n) {
		return this.points.get(n);
	}
	
	public String getType() {
		return TYPE;
	}
	
	public boolean isEmpty() {
		return this.getNumPoints() == 0;
	}
	
	public void translate(double dx, double dy) {
		
		for(Point point : points) {
			point.translate(dx, dy);
		}
		
		return;
	}
	
	public LineString clone() {
		List<Point> pointsClone = new ArrayList<Point>();
		for(Point point : this.points) {
			pointsClone.add(point.clone());
		}
		return new LineString(pointsClone);
	}
	
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}
	
}
