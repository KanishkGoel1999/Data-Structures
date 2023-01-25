package DSA;
import HW.MyLinkedList;
import HW.MyLinkedList.node;

public class LinkedList_Sort {

	public static void main(String[] args) {
		MyLinkedList<Integer> ll = new MyLinkedList<Integer>();
		ll.add(1);
		ll.add(1);
		ll.add(2);
		ll.add(0);
		ll.add(1);
		ll.add(2);
		ll.add(0);
		ll.add(0);
		ll.print(ll.head);
		sortApp2(ll);
		ll.print(ll.head);

	}
	
	static void sort0s1s2s(MyLinkedList ll) {
		
		node<Integer> temp = ll.head;
		int arr[] = new int[3];
		while(temp!=null) {
			if(temp.data==0) {
				arr[0]++;
			}
			else if(temp.data==1) {
				arr[1]++;
			}
			else {
				arr[2]++;
			}
			temp = temp.next;
		}
		
		temp = ll.head;
		while(temp!=null) {
			System.out.println("outer loop ran");
			while(arr[0]>0) {
				temp.data=0;
				temp=temp.next;
				arr[0]--;
			}
			while(arr[1]>0) {
				temp.data=1;
				temp=temp.next;
				arr[1]--;
			}
			while(arr[2]>0) {
				temp.data=2;
				temp=temp.next;
				arr[2]--;
			}
		}
	}
	
	static void sortApp2(MyLinkedList<Integer> ll) {
		MyLinkedList<Integer> ll0 = new MyLinkedList<Integer>();
		MyLinkedList<Integer> ll1 = new MyLinkedList<Integer>();
		MyLinkedList<Integer> ll2 = new MyLinkedList<Integer>();
		
		node<Integer> i = ll0.head;
		node<Integer> j = ll1.head;
		node<Integer> k = ll2.head;
		
		node<Integer> temp = ll.head;
		
		while(temp!=null) {
			if(temp.data==0) {
				i=
			}
			else if(temp.data==1) {
				ll1.add(temp);
			}
			else if(temp.data==2){
				ll2.add(temp);
			}
			
			System.out.println("11");
			temp = temp.next;
			
		}
		
		ll0.print(ll0.head);
		System.out.println("loop 1 comp");
		
		while(i.next!=null) {
			i=i.next;
		}
		i.next=ll1.head.next;
		i=ll1.head;
		while(i.next!=null) {
			i=i.next;
		}
		i.next = ll2.head.next;
		ll.head = ll0.head;
		
		
	}

}
