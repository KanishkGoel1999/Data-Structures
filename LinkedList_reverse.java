package DSA;
import HW.MyLinkedList;
import HW.MyLinkedList.node;

public class LinkedList_reverse {
	
	static void findMiddle(MyLinkedList<Integer> ll) {
		
		node<Integer> temp = ll.head;
		node<Integer> n = ll.head;
		if(ll.head==null) {
			System.out.println();
			System.out.println("Empty List");
			return;
		}
				
		while(n.next!=null) {
			temp=temp.next;
			if(n.next.next==null) {
				break;
			}
			n=n.next.next;
		}
		System.out.println();
		System.out.println(temp.data);
	}
	
	
	static void reverseIteration(MyLinkedList<Integer> ll) {
		node<Integer> pre = null;
		node<Integer> curr = ll.head;
		node<Integer> forw = curr.next;
		
		
		if(forw == null) {
			return;
		}
		else {
			while(curr!=null) {
				forw = curr.next;
				curr.next = pre;
				pre = curr;
				curr = forw;		
			}
		}
		//ll.head = pre.next;
		ll.print(pre);
	}
	
	
	
	static void reverseRecursion(MyLinkedList<Integer> ll, node<Integer> pre) {
		if(ll.head == null) {
			ll.head=pre;
			return;
		}
	
		node<Integer> curr = ll.head;
		ll.head = curr.next;
		
		curr.next = pre;
		
		reverseRecursion(ll, curr);	
		
	}
	
	
	

	public static void main(String[] args) {
		
		//node<Integer> head = new node<Integer>(3);
		
		MyLinkedList<Integer> ll = new MyLinkedList<Integer>();
		
		ll.add(3);
		ll.add(5);
		ll.add(7);
		ll.add(9);
		ll.print(ll.head);
		//reverseIteration(ll);
	
		reverseRecursion(ll, null);
		ll.print(ll.head);
		
		MyLinkedList<Integer> mll = new MyLinkedList<Integer>();
		mll.add(2);
		mll.add(4);
		
		//findMiddle(mll);
				
		
	}

}
