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
	private Circle[] circles;
	public void render(Circle[] circles) {
		this.circles = circles;
//		repaint canvas
		this.repaint();
		
		
	}

	
	
	
	private class AlgoCanvas extends JPanel{
		//use this g to paint
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
		

			Graphics2D g2d = (Graphics2D)g;
//			anti-aliased:
			RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			
			//actually drawing
//			AlgoVisHelper.setColor(g2d,Color.BLUE);
//			AlgoVisHelper.setStrokeWidth(g2d,5);
//			AlgoVisHelper.fillCircle(g2d, canvasWidth/2,canvasHeight/2 ,200 );
//			AlgoVisHelper.setColor(g2d,Color.RED);
//			AlgoVisHelper.strokeCircle(g2d, canvasWidth/2,canvasHeight/2 ,200 );
			
			AlgoVisHelper.setStrokeWidth(g2d, 1);
			AlgoVisHelper.setColor(g2d, Color.red);
            for(Circle circle: circles) {
                if(circle.isFilled)
                    AlgoVisHelper.fillCircle(g2d, circle.x, circle.y, circle.getR());
                else
                    AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());
			
            }
			
			

					
			
		}
		
//		//set size of canvas , now we dont need to write this line in  main
//		canvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight));
		public Dimension getPreferredSize() {
			return new Dimension(canvasWidth,canvasHeight);
			
		}
		
	}

}
