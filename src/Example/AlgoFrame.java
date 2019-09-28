package Example;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class AlgoFrame extends JFrame{
	private int canvasWidth;
	private int canvasHeight;
	public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
		super(title);
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
		
		AlgoCanvas canvas =  new AlgoCanvas();

		//we use canvas as our content pane
		setContentPane(canvas);
		//auto size our frame 
		pack();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
	
		
		
		
	}
	public int getCanvasWidth() {
		return canvasWidth;
		
	}
	public int getCanvasHeight() {
		return canvasHeight;
		
	}
	public AlgoFrame(String title) {
		this(title,1024,768);
	}
	private class AlgoCanvas extends JPanel{
		//use this g to paint
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			// draw oval
//			g.drawOval(50, 50, 300, 300);
//			convert to 2d
//			create line width
			int strokeWidth = 10;

			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(Color.RED);
			Ellipse2D circle =  new Ellipse2D.Double(50,50,300,300);
			g2d.draw(circle);
			g2d.setStroke(new BasicStroke(strokeWidth));
			//draw a solid circle
			Ellipse2D circle2 =  new Ellipse2D.Double(60,60,280,280);
			g2d.fill(circle2);
					
			
		}
		
//		//set size of canvas , now we dont need to write this line in  main
//		canvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight));
		public Dimension getPreferredSize() {
			return new Dimension(canvasWidth,canvasHeight);
			
		}
		
	}

}
