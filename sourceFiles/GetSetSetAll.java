import java.util.ArrayList;

/* Data structure which supports get, set and setAll operations in O(1).
 * get(i) returns the i'th element's value.
 * set(i,val) sets the i'th value to val.
 * setAll(val) sets all of the elements in the structure to hold value val.
 *
 * This structure is based on attaching a timestamp to each element in order to keep track of the latest
 * value this element holds.
 */
class GetSetSetAll <T> {
	private TimeStampedValue globalValue;
	private int timeStampCounter;
	private ArrayList<TimeStampedValue> vals;
	// constructor
	GetSetSetAll(){
		this.vals = new ArrayList<>();
		this.timeStampCounter = -1; // so that the first global value won't interfere with the rest
		this.globalValue = new TimeStampedValue(this.timeStampCounter,null); // our "setAll value"
	}
	// add method
	void add(T value){
		this.vals.add(new TimeStampedValue(++this.timeStampCounter,value));
	}
	// get and set methods
	T get(int index){
		return vals.get(index).getValue();
	}
	void set(int index, T value){
		vals.get(index).set(value,++this.timeStampCounter);
	}
	// setAll method
	void setAll(T value){
		this.globalValue.set(value,++this.timeStampCounter);
	}
	// utility
	void printAll(){
		for (TimeStampedValue val : this.vals) { System.out.print(val + " "); }
		System.out.println();
	}
	// wrapper class for the values
	private class TimeStampedValue{
		private int timeStamp;
		private T value;
		// constructor
		TimeStampedValue(int timeStamp, T val){
			this.timeStamp = timeStamp;
			this.value = val;
		}
		T getValue(){ // return the latest version of this item
			return this.timeStamp>globalValue.timeStamp? this.value:globalValue.value;
		}
		void set(T val, int newTimeStamp){
			this.value = val;
			this.timeStamp = newTimeStamp;
		}
		// utility
		public String toString(){
			return ""+this.getValue();
		}
	}
}
