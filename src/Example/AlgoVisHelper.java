package Example;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoVisHelper {
	private AlgoVisHelper() {}
	public static void  setStrokeWidth(Graphics2D g2d,int w) {
		int strokeWidth = w;
		g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
	}
	public static void setColor(Graphics2D g2d,Color color) {
		g2d.setColor(color);
		
	}
//	draw in circle
	public static void strokeCircle(Graphics2D g2d, int x, int y, int r) {
		Ellipse2D circle = new Ellipse2D.Double(x-r,y-r,2*r,2*r);
		g2d.draw(circle);
		
	}
	
//	fill in circle
	public static void fillCircle(Graphics2D g2d, int x, int y, int r) {
		Ellipse2D circle = new Ellipse2D.Double(x-r,y-r,2*r,2*r);
		g2d.fill(circle);
		
	}
	
	public static void pause (int t) {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in sleeping");
		}
	}

}
