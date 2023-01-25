package DSA;
import HW.MyLinkedList;
import HW.MyLinkedList.node;

public class LinkedList_AddNumbers {

	public static void main(String[] args) {
		MyLinkedList<Integer> all = new MyLinkedList<Integer>();
		MyLinkedList<Integer> bll = new MyLinkedList<Integer>();
		all.add(3);
		all.add(6);
		all.add(9);
		bll.add(2);
		bll.add(7);
		
		all.print(all.head);
		System.out.print("  -> ");
		bll.print(bll.head);
		MyLinkedList<Integer> sumLL = add(all,bll);
		sumLL.print(sumLL.head);

	}

	
	static MyLinkedList<Integer> add(MyLinkedList<Integer> all, MyLinkedList<Integer> bll) {
		node<Integer> a = all.head;
		node<Integer> b = bll.head;
		MyLinkedList<Integer> sumLL = new MyLinkedList<Integer>();
		
		a = reverse(a);
		b = reverse(b);
		int carry = 0;
		while(b!= null) {
			int sum = a.data + b.data + carry;
			if(sum<10) {
				sumLL.add(sum);
			}
			else {
				carry=1;
				sumLL.add(sum%10);
			}
			
			a= a.next;
			b = b.next;	
		}
		
		while(a!=null) {
			sumLL.add(a.data+carry);
			carry--;
			a=a.next;
		}
		node<Integer> s = reverse(sumLL.head);
		sumLL.head = s;
		
		return sumLL;
		
		
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
