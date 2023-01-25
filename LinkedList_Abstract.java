package DSA;




public class LinkedList_Abstract<E> {
	
// linear data struct which collection of nodes containing data and address of next node
// better than arrays, arraylist
//	no memory wasted
//	no shifting needed while adding
//	singly, doubly, circular,
	
	
	public node<E> head;
	
	tut44_LinkedLists(E data){
		head.data = data;
		head.next=null;
		
	}
	
	
	
	public static class node<E>{
		
		E data;
		node<E> next;
		
		node(E data){
			this.data = data;
			next = null;
		}
		
	}
	
	
	
	void insertAtHead(E data) {
		node<E> temp = new node<E>(data);
		temp.next = head;
		head = temp;
	}
	
	void insertAtEnd(E data) {
		node<E> toInsert =new node<E>(data);
		if(head==null) {
			head = toInsert;
			return;
		}
		node<E> temp = head;
		while(temp.next!=null) {
			temp= temp.next;
		}
		
		
		temp.next = toInsert;
		toInsert.next=null;
		
	}
	
	void insertAt(E data, int n) {
		
		if(n==1) {
			insertAtHead(data);
			return;
		}
		node<E> temp = head;
		int i=0;
		while(i<n) {
			temp = temp.next;
			i++;
		}
		node<E> toInsert = new node<E>(data);
		toInsert.next = temp.next;
		temp.next = toInsert;
		
		if(toInsert.next==null) {
			//tail = toInsert;
			return;
		}
			
	}
	
	void deleteAtPosition(int n) {
		
		node<E> temp = head;
		if(n==1) {
			head= head.next;
			return;
		}
		
		int i=0;
		while(i<n-1) {
			temp = temp.next;
			i++;		
		}
		temp.next = temp.next.next;
		
		
	}
	
	void deleteAtValue(E data) {
		node<E> temp = head;
		if(head.data == data) {
			head=head.next;
			return;
		}
		 while(temp.next.data != data) {
			 temp = temp.next;
		 }
		 
		 if(temp.next!=null) {
		 temp.next = temp.next.next;
		 }
		 
	}
	
	void print() {
		node<E> temp = head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	
	

}


