package PS6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * A multi-segment Shape, with straight lines connecting "joint" points -- (x1,y1) to (x2,y2) to (x3,y3) ...
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Spring 2016
 * @author CBK, updated Fall 2016
 */
public class Polyline implements Shape {
	Color color;
	ArrayList<Point> pointList;

	public Polyline(){
		pointList = new ArrayList<>();
	}

	public void add(int x, int y){
		pointList.add(new Point(x, y));
	}

	@Override
	public void moveBy(int dx, int dy) {
		for (int i = 0; i < pointList.size(); i ++){
			Point temp = pointList.get(i);
			pointList.add(i, new Point(temp.x + dx, temp.y + dy));
		}
	}

	@Override
	public Color getColor() {
		return  color;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public boolean contains(int x, int y) {
		for (Point u: pointList){
			if (u.x == x && u.y == y){
				return true;
			}
		}
		return false;
	}

	@Override
	public void draw(Graphics g) {
		for (int i = 0; i < pointList.size() - 1; i++){
			g.drawLine(pointList.get(i).x, pointList.get(i).y, pointList.get(i +1).x, pointList.get(i +1).y );
		}
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for ( Point u: pointList){
			str.append("polyline ").append(u.x).append(" ").append(u.y).append(" ").append(color.getRGB());
		}
		return str.toString();
	}
}
