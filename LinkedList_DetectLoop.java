package DSA;
import HW.myLL;
import HW.myLL.node;
import java.util.*;

public class LinkedList_DetectLoop {

	public static void main(String[] args) {
		
		myLL<Integer> mll = new myLL<Integer>();
		myLL<Integer> ll = new myLL<Integer>();
		for(int i=0; i<10; i++) {
			mll.add(i);
			ll.add(i);
		}
		node<Integer> temp = mll.head;
		node<Integer> pivot = mll.head;
		for(int i=0; i<9; i++) {
			if(i==6) {
				pivot = temp;
			}
			temp = temp.next;
		}
		temp.next = pivot;
		
		System.out.println(detectLoop(mll));
		System.out.println();
		System.out.println(floydCycle(ll));
		System.out.println();
		System.out.println("Loop starts at " + loopStart(mll).data);
		System.out.println();
		removeLoop(mll); 
		mll.print(mll.head);
		
		
	}
	
	static boolean detectLoop(myLL<Integer> ll) {
		
		Map<node<Integer>, Boolean> hm = new HashMap<node<Integer>, Boolean>();
		node<Integer> temp = ll.head;
		
		while(temp!=null) {
			if(hm.containsKey(temp)) {
				return true;
			}
			hm.put(temp, true);
			temp = temp.next;
		}
		
		return false;
	}
	
	static boolean floydCycle(myLL<Integer> ll) {
		node<Integer> slow = ll.head;
		node<Integer> fast = ll.head;
		
		while(fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) {
				return true;
			}	
			if(fast==null) {
				return false;
			}
		}
		
		return false;
	}
	
	static node<Integer> loopStart(myLL<Integer> ll) {
		
		if(!floydCycle(ll)) {
			return null;
		}
		node<Integer> slow = ll.head;
		node<Integer> fast = ll.head;
		
		while(fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) {
				break;
			}	
		}
		slow = ll.head;
		
		while(slow!=fast) {
			slow=slow.next;
			fast=fast.next;
		}
		
		//System.out.println("Loop starts at " + slow.data);
		return slow;
		
	}
	
	static void removeLoop(myLL<Integer> ll) {
		if(!floydCycle(ll)) {
			return;
		}
		node<Integer> pivot = loopStart(ll);
		node<Integer> temp = pivot.next;
		
		while(temp.next!=pivot) {
			temp=temp.next;
		}
		temp.next = null;
		
		
	}
	

}
