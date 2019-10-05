package SelectionSort;

public class SelectionSort {
	private int [] numbers;
	public int orderedIndex = -1, currentMinIndex = -1, currentCompareIndex = -1;
	//initialize with total number we want to sort and 
	public SelectionSort(int N, int randomBound) {
		numbers = new int[N];
		for(int i = 0; i < N; i++) {
			//it can not be a number 0 
			numbers[i] = (int) (Math.random()*randomBound) + 1;
			
		}	
	}
	
	//get size of array
	public int size() {
		return numbers.length;
	}
	// get current index value
    public int get(int index){
        if( index < 0 || index >= numbers.length)
            throw new IllegalArgumentException("Invalid index to access Sort Data.");

        return numbers[index];
    }
    
    //swap method
    public void swap(int i, int j) {

        if( i < 0 || i >= numbers.length || j < 0 || j >= numbers.length)
            throw new IllegalArgumentException("Invalid index to access Sort Data.");

        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }

}
