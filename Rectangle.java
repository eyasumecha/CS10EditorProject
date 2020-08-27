package PS6;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A rectangle-shaped Shape
 * Defined by an upper-left corner (x1,y1) and a lower-right corner (x2,y2)
 * with x1<=x2 and y1<=y2
 * 
 * @author Chris Bailey-Kellogg, Dartmouth CS 10, Fall 2012
 * @author CBK, updated Fall 2016
 */
public class Rectangle implements Shape {
	private int x2, y2, x1, y1;
	private Color color;

	public Rectangle(int x, int y, Color color){
		this.x1 = x; this.y1 = y;
		x2= x; y2= y;
		this.color = color;
	}


	public Rectangle(int x, int y, int x1, int y1, Color color){
		this.x1 = Math.min(x, x1); this.y1 = Math.min(y, y1);
		this.x2= Math.max(x, x1); this.y2 = Math.max(y, y1);
		this.color = color;

	}
	@Override
	public void moveBy(int dx, int dy) {
		this.x2 += dx; this.y2 += dy;
		this.x1 += dx; this.y1 += dy;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}
		
	@Override
	public boolean contains(int x, int y) {
		double a = (x2-x1)/2.0, b = (y2-y1)/2.0;
		double dx = x - (x1 + a); // horizontal distance from center
		double dy = y - (y1 + b); // vertical distance from center

		// Apply the standard geometry formula. (See CRC, 29th edition, p. 178.)
		return Math.pow(dx / a, 2) + Math.pow(dy / b, 2) <= 1;

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x1, y1, x2 - x1, y2 - y1);
	}

	public String toString() {
		return "rectangle " +x1+ " " +y1+ " " +x2+ " " +y2+ " " + color.getRed()+" "+color.getGreen()+" "+color.getBlue();
	}
}
