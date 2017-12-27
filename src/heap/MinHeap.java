package heap;

public class MinHeap {
	private int[] dataArray;
	private int heapSize = -1;
	private int heapCapacity;
	public MinHeap(int length) {
		// TODO Auto-generated constructor stub
		this.dataArray = new int[length];
		this.heapCapacity = length;
	}
	private int getLeftChildIndex(int parentIndex){
		return (parentIndex*2)+1;
	}
	private int getRightChildIndex(int parentIndex){
		return (parentIndex*2)+2;
	}
	private int getParentIndex(int childIndex){
		return (childIndex-1)/2;
	}
	
	//With assumption child tree all ready heapified
	private void minHeapify(int index){
		int smallestIndex = index;
		int leftChildIndex = this.getLeftChildIndex(index);
		int rightChildIndex = this.getLeftChildIndex(index);
		if( leftChildIndex < this.heapSize && this.dataArray[index] > this.dataArray[leftChildIndex]){
			smallestIndex = leftChildIndex;
		}
		if( rightChildIndex < this.heapSize && this.dataArray[index] > this.dataArray[rightChildIndex]){
			smallestIndex = leftChildIndex;
		}
		if(smallestIndex != index){
			this.swap(smallestIndex, index);
			this.minHeapify(smallestIndex);
		}
	}
	private void swap(int key1, int key2){
		int temp = this.dataArray[key1];
		this.dataArray[key1] =  dataArray[key2];
		this.dataArray[key2] =  temp;
	}
	public int getMinimum(){
		if(heapSize == -1){
			return -1;
		}
		return this.dataArray[0];
	}
	public int extractMinimum(){
		int minimum = this.getMinimum();
		this.dataArray[0] = this.dataArray[this.heapSize--];
		this.minHeapify(0);
		return minimum;
	}
	public boolean insert(int value){
		if (heapSize >= heapCapacity - 1) {
            return false;
        }
		this.dataArray[++heapSize] = value;
		for(int i = heapSize; i != 0 && 
				this.dataArray[this.getParentIndex(i)]> this.dataArray[i];){
			this.swap(getParentIndex(i),i);
			i = this.getParentIndex(i);
		}
		return true;
	}
	public void decreaseKey(int key,int value){
		
	}
	public void delete(int value){
		
	}

}
