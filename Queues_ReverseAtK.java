package DSA;
import HW.myQueue;
import HW.myStack;
import HW.myLL;
import java.util.*;

import HW.myQueue;

public class Queues_ReverseAtK {

	public static void main(String[] args) {
		
		myQueue<Integer> mq = new myQueue<Integer>();
		for(int i=1; i<7; i++) {
			mq.enQueue(i);
		}
		mq.print();
		mq = reverseAtK(mq, 4);
		mq.print();
		String s = "aabc";
		firstNonRep(s);
		}
	
	static myQueue<Integer> reverseAtK(myQueue<Integer> mq, int k){
		myStack<Integer> st = new myStack<Integer>();
		myQueue<Integer> ansQ = new myQueue<Integer>();
		for(int i=0; i<k; i++) {
			st.push(mq.front.data);
			mq.deQueue();
		}
		
		while(!st.isEmpty()) {
			ansQ.enQueue(st.pop());
		}
		while(!mq.isEmpty()) {
			ansQ.enQueue(mq.front.data);
			mq.deQueue();
		}
		
		return ansQ;
	}
	
	static void firstNonRep(String s) {
		//Map<Integer, Character> cnt = new HashMap<Integer, Character>();
		myQueue<Character> mq = new myQueue<Character>();
		int arr[] = new int[26];
		int length = s.length();
		int i=0;
		while(i<length) {
			char c = s.charAt(i);
			arr[c-97]++;
			mq.enQueue(c);
			
			while(!mq.isEmpty()) {
				if(arr[mq.front.data-97]>1) {
					mq.deQueue();
				}
				else {
					System.out.println(mq.front.data);
					break;
				}
			}
			
			if(mq.isEmpty()) {
				System.out.println("#");
			}
			i++;
			
		}
	}
}
