package SelectionSort;

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
	private SelectionSort data;
	public void render(SelectionSort data) {
		this.data = data;
//		repaint canvas
		this.repaint();
		
		
	}

	
	
	
	private class AlgoCanvas extends JPanel{
		//use this g to paint
		@Override
	        public void paintComponent(Graphics g) {
	            super.paintComponent(g);

	            Graphics2D g2d = (Graphics2D)g;

	            // anti aliasing
	            RenderingHints hints = new RenderingHints(
	                    RenderingHints.KEY_ANTIALIASING,
	                    RenderingHints.VALUE_ANTIALIAS_ON);
	            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	            g2d.addRenderingHints(hints);

	            // actually drawing column
	            int w = canvasWidth/data.size();
	            AlgoVisHelper.setColor(g2d, AlgoVisHelper.LightBlue);
	            for(int i = 0 ; i < data.size() ; i ++ ) {
	            	  if (i < data.orderedIndex)
	                      AlgoVisHelper.setColor(g2d, AlgoVisHelper.Red);
	                  else
	                      AlgoVisHelper.setColor(g2d, AlgoVisHelper.Grey);
	            	  // if we find out current index is the one we want to compare 
	                  if(i == data.currentCompareIndex)
	                      AlgoVisHelper.setColor(g2d, AlgoVisHelper.LightBlue);
	                  if(i == data.currentMinIndex)
	                      AlgoVisHelper.setColor(g2d, AlgoVisHelper.Indigo);
	                  AlgoVisHelper.fillRectangle(g2d, i * w, canvasHeight - data.get(i), w - 1, data.get(i));
	            }
	        }
		
//		//set size of canvas , now we dont need to write this line in  main
//		canvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight));
		public Dimension getPreferredSize() {
			return new Dimension(canvasWidth,canvasHeight);
			
		}
		
	}

}
