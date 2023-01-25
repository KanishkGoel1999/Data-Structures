package DSA;
import HW.MyLL;
import HW.MyLL.node;
import HW.mergeSortedLL;


public class LinkedList_MergeSort {

	public static void main(String[] args) {
		MyLL<Integer> ll = new MyLL<Integer>();
		ll.add(4);
		ll.add(3);
		ll.add(7);
		ll.add(2);
		ll.add(9);
		ll.add(6);
		ll.add(8);
		ll.add(1);
		
		ll.print(ll.head);
		ll.head = mergeSort(ll.head);
		ll.print(ll.head);
		

	}
	
	static node<Integer> mergeSort(node<Integer> head) {
		if(head==null || head.next==null) {
			return head;	
		}
		
		node<Integer> one = head;
		node<Integer> mid = findMid(head);
		node<Integer> two = mid;
		
		while(one.next!=mid) {
			//System.out.println(one.data);
			one=one.next;
		}
		one.next=null;
		one = head;
		one = mergeSort(one);   
		two = mergeSort(two);
		
		return merge(one, two);
		
		
				
	}
	
	static node<Integer> findMid(node<Integer> head){
		node<Integer> slow = head;
		node<Integer> fast = head;
		
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
	
	static node<Integer> merge( node<Integer> aHead, node<Integer> bHead) {
		
		node<Integer> i = aHead;
		node<Integer> j = bHead;
		
		if(aHead==null) {
			return bHead;
		}
		
		if(bHead==null) {
			return aHead;
		}
		
		node<Integer> temp = new node<Integer>(-1);
		
		while(i!=null && j!=null) {
			if(i.data<j.data) {
				temp = i;
				i=i.next;
				temp.next = j;
			}
			
			else {
				temp = j;
				j = j.next;
				temp.next = i;
			}
		}
		
		if(aHead.data>bHead.data) {
			bHead.next = aHead;
			return bHead;
		}
		else {
			aHead.next = bHead;
			return aHead;
			
		}
		
	}

}
