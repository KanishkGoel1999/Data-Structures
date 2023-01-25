package DSA;
import HW.myQueue;
import HW.myStack;
import HW.myLL;
import java.util.*;

public class Queues_Reverse {

	public static void main(String[] args) {
		
		myQueue<Integer> mq = new myQueue<Integer>();
		for(int i=1; i<7; i++) {
			mq.enQueue(i);
		}
		mq.print();
		mq = reverseApp1(mq);
		
		mq.print();
		reverseApp2(mq);
		mq.print();
		
		int arr[] = {-8,2,3,-6,10};
		myQueue<Integer> nq = new myQueue<Integer>();
		ArrayList<Integer> brr = firstNeg(arr, 2);
		for(int i=0; i<brr.size(); i++) {
			System.out.println(brr.get(i));
		}
		nq.print();
	}
	
	static myQueue<Integer> reverseApp1(myQueue<Integer> mq) {
		myStack<Integer> st = new myStack<Integer>();
		
		while(!mq.isEmpty()) {
			int element = mq.front.data;
			mq.deQueue();
			st.push(element);
		}
		
		while(!st.isEmpty()) {
			mq.enQueue(st.pop());
		}
		return mq;
	}
	
	static void reverseApp2(myQueue<Integer> mq) {
		if(mq.isEmpty()) {
			return;
		}
		
		int a = mq.front.data;
		mq.deQueue();
		reverseApp2(mq);
		mq.enQueue(a);
	}
	
	static ArrayList<Integer> firstNeg(int arr[], int k) {
		ArrayList<Integer> brr = new ArrayList<Integer>();
		myQueue<Integer> mq = new myQueue<Integer>();
		
		int s=0;
		int i=0;
		while(s<arr.length-k+1) {
			i=s;
			while(i<k+s) {
				mq.enQueue(arr[i]);
				i++;
			}
			while(!mq.isEmpty()) {
				int element = mq.front.data;
				if(element<0) {
					brr.add(element);
					mq.deQueue();
				}
				else{mq.deQueue();}
				
			}
			
			s++;
		}
		
		return brr;
	}
	
	

}
