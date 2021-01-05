package org.acme.geometry;

public class WktWriter {
	
	public WktWriter() {
		
	}
	
	public String write(Geometry geometry) {
		
		if ( geometry instanceof Point ){
		    Point point = (Point)geometry;
		    if(point.isEmpty()) {
		    	return "POINT EMPTY";
		    }
		    else {
		    	return "POINT(" + writerCoordinate(point.getCoordinate()) +")";
		    }
		}else if ( geometry instanceof LineString ){
		    LineString lineString = (LineString)geometry;
		    if(lineString.isEmpty()) {
		    	return "LINESTRING EMPTY";
		    }
		    else {
		    	String str = "LINESTRING(" + writerCoordinate(lineString.getPointN(0).getCoordinate());
		    	for(int i = 1 ; i<lineString.getNumPoints() ; i++) {
		    		str += "," + writerCoordinate(lineString.getPointN(i).getCoordinate());
		    	}
		    	return str + ")";
		    }
		}else{
		    throw new RuntimeException("geometry type not supported");
		}
		
	}
	
	public static String writerCoordinate(Coordinate coordinate) {
		return coordinate.getX() + " " + coordinate.getY();
	}
	
}
