package DSA;
import java.util.Scanner;
import HW.myLL.node;
import HW.myLL;

public class LinkedList_RemoveDuplicates {

	// use ed2 loops : T(n) = O(n^2)
	// sort the LL and rem : T(n) = O(nlogn)
	// use maps : T(n) = O(n)
	public static void main(String[] args) {
		
		myLL<Integer> ll = new myLL<Integer>();
		myLL<Integer> mll = new myLL<Integer>();
		for(int i=0; i<10; i++) {
			ll.add(i);
			mll.add(i);
			mll.add(i+1);
			for(int j=0; j<i-1; j++) {
				ll.add(i);
				mll.add(i);
			}
		}
		
		ll.print(mll.head);
		//remDupFromSorted(ll);
		//ll.print(ll.head);
		remDupFromUnsorted(mll);
		ll.print(mll.head);
		
		
		
	}
	
	static void remDupFromUnsorted(myLL<Integer> ll) {
		node<Integer> temp = ll.head;
		while(temp!=null) {
			node<Integer> i = temp;
			node<Integer> j = temp.next;
			while(j!=null) {
				if(temp.data==j.data) {
					i.next=j.next;
					j=j.next;
				}
				else if(i==j){
					j=j.next;
				}
				else {
					i=i.next;
					j=j.next;
				}
			}
			temp = temp.next;
		}
		
	}
	
	static void remDupFromSorted(myLL<Integer> ll) {
		
		node<Integer> temp = ll.head;
		
		
		while(temp!=null) {
			node<Integer> i = temp;
			while(temp.data==i.data) {
				i=i.next;
				if(i==null) {
					break;
				}
			}
			temp.next = i;
			temp = temp.next;
		}
		
		
	}

}
