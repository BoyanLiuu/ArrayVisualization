package InsertionSortVisualization;

import java.awt.*;

public class AlgoVisualizer {

    private static int DELAY = 40;

    private InsertionSortData data;
    private AlgoFrame frame;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){

        // initialize
        data = new InsertionSortData(N, sceneHeight);

        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Insertion Sort Visualization", sceneWidth, sceneHeight);

            new Thread(() -> {
                run();
            }).start();
        });
    }

    public void run(){

        setData(0, -1);

        for( int i = 0 ; i < data.N() ; i ++ ){

            setData(i, i);
            for(int j = i ; j > 0 && data.get(j) < data.get(j-1) ; j --){
                data.swap(j,j-1);
                setData(i+1, j-1);
            }
        }
        setData(data.N(), -1);

    }

    private void setData(int orderedIndex, int currentIndex){
        data.orderedIndex = orderedIndex;
        data.currentIndex = currentIndex;

        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 100;

        AlgoVisualizer vis = new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }
}