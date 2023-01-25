package DSA;
import HW.MyLinkedList;
import HW.MyLinkedList.node;

public class LinkedList_CheckPalindrome {

	public static void main(String[] args) {
			
		MyLinkedList<Integer> ll = new MyLinkedList<Integer>();
		ll.add(2);
		ll.add(4);
		ll.add(7);
		ll.add(9);
		ll.add(7);
		ll.add(4);
		ll.add(2);
		ll.print(ll.head);
		
		System.out.println(checkPalApp2(ll));
		checkPalApp2(ll);
		ll.print(ll.head);
		
		

	}
//App 1: make an array and use 2 pointer approach ; T(n) = O(n); S(n) = O(n)
//App 2: use maps  ; 
//App 3: reverse 2nd half of LL
	
	static boolean checkPalApp2(MyLinkedList<Integer> ll) {
		node<Integer> s = ll.head;
		int size = ll.size();
		if(size%2==1) {
			size++;
		}
		for(int i=0; i<size/2; i++) {
			s = s.next;
		}
		
		node<Integer> e = reverse(s);
		s = ll.head;
		boolean ans  = false;
		while(s!=e) {
			if(s.data!=e.data) {
				ans = false;
				break;
			}
			s=s.next;
			e=e.next;
			if(e==null) {
				ans = true;
				break;
			}
			
		}
		
		s = ll.head;
		
		for(int i=0; i<size/2; i++) {
			s = s.next;
		}
		reverse(s);
		
		
		return ans;
		
		
	}
	
	static node<Integer> reverse(node<Integer> h) {
		node<Integer> pre = null;
		node<Integer> curr = h;
		node<Integer> forw = curr.next;
		
		
		if(forw == null) {
			return null;
		}
		else {
			while(curr!=null) {
				forw = curr.next;
				curr.next = pre;
				pre = curr;
				curr = forw;		
			}
		}
		
		return pre;
		
	}
}
