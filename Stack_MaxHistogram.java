package DSA;
import HW.myStack;
import java.util.Arrays;

////////////ERROR//////////


public class Stack_MaxHistogram {

	public static void main(String[] args) {
		
		int arr[] = {2,1,5,6,2,3};
		myStack<Integer> st = new myStack<Integer>();
		
		st= maxHisto(arr);
		st.print();
		

	}

	static myStack<Integer> maxHisto(int arr[]) {
		
		myStack<Integer> st = new myStack<Integer>();
		int next[] = new int[arr.length];
		int prev[] = new int[arr.length];
		
		next = nextSmaller(arr);
		prev = prevSmaller(arr);
		
		
		for(int i=0; i<arr.length; i++) {
			int b = next[i] - prev[i] - 1;
			st.push(arr[i]*b);
		}
		return st;
		

	}
	
	
	static int[] nextSmaller(int arr[]) {
		myStack<Integer> st = new myStack<Integer>();
		int brr[] = new int[arr.length];
		st.push(-1);
		
		int i = arr.length-1;
		while(i>=0) {
			int element = arr[i];
			if(st.peek()<element ) {
				if(st.peek()==-1) {
					brr[i] = arr.length;
					st.push(element);
					i--;
				}
				else {
					brr[i] = i;
					st.push(element);
					i--;
				}
			}
			else {
				while(st.peek()>element) {
					
					st.pop();
				}
				if(st.peek()==-1) {
					brr[i] = arr.length;
					st.push(element);
					i--;
				}
				else {
					brr[i] = i;
					st.push(element);
					i--;
				}
			}
		}
		
		return brr;
		
		
	}
	
	static int[] prevSmaller(int arr[]) {
		myStack<Integer> st = new myStack<Integer>();
		int brr[] = new int[arr.length];
		st.push(-1);
		
		int i = 0;
		while(i<arr.length) {
			int element = arr[i];
			if(st.peek()<element) {
				if(st.peek()==-1) {
					brr[i] = 0;
					st.push(element);
					i++;
				}
				else {
					brr[i] = i;
					st.push(element);
					i++;
				}
			}
			else {
				while(st.peek()>element) {
					
					st.pop();
				}
				if(st.peek()==-1) {
					brr[i] = 0;
					st.push(element);
					i++;
				}
				else {
					brr[i] = st.peek();
					st.push(element);
					i++;
				}
			}
		}
		
		return brr;
		
		
	}
	

}
