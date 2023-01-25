package DSA;
import HW.MyLinkedList;
import HW.MyLinkedList.node;

public class LinkedList_Problems {

	public static void main(String[] args) {
		
		MyLinkedList<Integer> ll = new MyLinkedList<Integer>();
		MyLinkedList<Integer> mll = new MyLinkedList<Integer>();
		
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		ll.print(ll.head);
		System.out.println();
		ll.head = reverseAtK(ll.head, null, 3);
		ll.print(ll.head);
		

		mll.add(1);
		mll.add(2);
		mll.add(3);
		mll.add(4);
		mll.add(5);
		mll.add(6);
		node<Integer> temp = mll.head;
		while(temp.next!=null) {
			temp = temp.next ;
		}
		temp.next = mll.head;
		
		System.out.println();
		System.out.println(isCircular(mll));
		
		
	}
	
	static void reverseFromk1Tok2(MyLinkedList<Integer> ll , node<Integer> pre, node<Integer> curr, int k1, int k2) {
		if(k1>k2 || curr==null) {
			ll.head.next = curr;

			ll.head = pre;
			System.out.println("base case");
			
			
			return;
		}

		node<Integer> temp = curr.next;
		curr.next = pre;
		pre = curr;
		curr = temp;
		k1++;
		reverseFromk1Tok2(ll, pre, curr, k1, k2);	
		
	}
	
	static node<Integer> reverseAtK(node<Integer> h, node<Integer> pre, int k) {
		
		if(h==null) {
			 
			return null;
		}
		int cnt=0;
		node<Integer> curr = h;
		node<Integer> forw = curr.next;
		
		
		while(cnt!=k) {
			forw = curr.next;
			curr.next = pre;
			pre = curr;
			curr = forw;
			cnt++;
		}
		
		h.next = reverseAtK(curr, pre, k);
		return pre;
		
	}
	
	static boolean isCircular(MyLinkedList<Integer> ll) {
		
		if(ll.head==null) {
			return true;
		}
		
		node<Integer> pivot = ll.head;
		node<Integer> temp = pivot.next;
		
		while(temp!=null) {
			if(temp==pivot) {
				return true;
			}
			temp = temp.next;
		}
		
		return false;
		
	}

}
