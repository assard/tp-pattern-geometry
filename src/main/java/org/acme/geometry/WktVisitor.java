package org.acme.geometry;

public class WktVisitor implements GeometryVisitor{
	
	private StringBuilder buffer;
	
	public WktVisitor() {
		this.buffer = new StringBuilder("");
	}
	
	public void visit(Point point) {
	    if(point.isEmpty()) {
	    	this.buffer.append("POINT EMPTY");
	    }
	    else {
	    	this.buffer.append("POINT(" + WktWriter.writerCoordinate(point.getCoordinate()) +")");
	    }
	}
	
	public void visit(LineString lineString) {
		if(lineString.isEmpty()) {
	    	this.buffer.append("LINESTRING EMPTY");
	    }
	    else {
	    	String str = "LINESTRING(" + WktWriter.writerCoordinate(lineString.getPointN(0).getCoordinate());
	    	for(int i = 1 ; i<lineString.getNumPoints() ; i++) {
	    		str += "," + WktWriter.writerCoordinate(lineString.getPointN(i).getCoordinate());
	    	}
	    	this.buffer.append(str + ")");
	    }
	}
	
	public String getResult() {
		return this.buffer.toString();
	}

}
