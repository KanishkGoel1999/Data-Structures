package DSA;

public class LinkedList_Circular<E> {

	class node<E>{
		E data;
		node<E> next;
		
		node(E data){
			this.data = data;
			this.next = null;
		}
	}
	
	public node<E> head;
	

}
