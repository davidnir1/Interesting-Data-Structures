import java.util.ArrayList;

/*
 * Data structure for holding integers which supports the following commands in O(1):
 * get(index) returns the value at index
 * set(index,val) sets the index'th value to val
 * incAll increments all the values by 1
 *
 * This structure utilizes an ArrayList.
 * This structure works by counting how many times an incAll command has been used, and upon using a set
 * command, it will set the element's value to be value-incCounter, so that on the next time we use get on
 * this element, we will get the correct incremented value.
 */
class GetSetIncAll {

	private ArrayList<Integer> vals;
	private int incCounter; // our global increment counter

	// constructor
	GetSetIncAll(){
		this.vals = new ArrayList<>();
		this.incCounter = 0;
	}
	// add method
	void add(int val){
		this.vals.add(val);
	}
	// we return the current value + current incCounter, this ensures we get the correct increment amount
	int get(int index){
		return this.vals.get(index)+this.incCounter;
	}
	// we set the new value to be value - current incCounter
	void set(int index, int value){
		this.vals.set(index, value-this.incCounter);
	}
	// increment all of the values
	void incAll(){
		this.incCounter++;
	}
	// utility
	void printAll(){
		for(int i=0;i<this.vals.size();i++){
			System.out.print(get(i)+" ");
		}
		System.out.println();
	}
}
