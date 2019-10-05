package SelectionSort;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//Controller
public class AlgoVisualizer {

    private SelectionSort data;
    private AlgoFrame frame;
    private static int DELAY = 1;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){

        // initialize visualization
        data = new SelectionSort(N,sceneHeight);

         //better use eventQueue
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Selection Sort Visualization", sceneWidth, sceneHeight);
             // draw animation, have to use another thread
            new Thread(() -> {
                run();
            }).start();
        });
    }

    	// animation algorithm
 private void run(){

	 	setData(0, -1, -1);
        //Selection Sort
        for( int i = 0 ; i < data.size() ; i ++ ){
            
            int minIndex = i;
            setData(i, -1, minIndex);
            for( int j = i + 1 ; j < data.size() ; j ++ ){
            	// drawing canvas
            	
            	setData(i, j, minIndex);
                if( data.get(j) < data.get(minIndex) ){
                    minIndex = j;
                    setData(i, j, minIndex);
                }
            }
            //draw at each time we sort, when the array is changed
            data.swap(i , minIndex);
            setData(i+1, -1, -1);
        }
        //another draw when we finish the sort
        setData(data.size(),-1,-1);
    }

 private void setData(int orderedIndex, int currentCompareIndex, int currentMinIndex){
     data.orderedIndex = orderedIndex;
     data.currentCompareIndex = currentCompareIndex;
     data.currentMinIndex = currentMinIndex;

     frame.render(data);
     AlgoVisHelper.pause(DELAY);
 }
 

  public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 100;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }
}
