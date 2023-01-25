package DSA;
import HW.myStack;

public class Stack_Problems {
	//1: firstSmallerElement
	
	public static void main(String[] args) {
		
		int arr[] = {2,1,4,3};
		int crr[] = {2,3,1};
		int brr[] = firstSmallerElement(arr);
		for(int i=0; i<brr.length; i++) {
			System.out.println(brr[i]);
		}

	}
	
	static int[] firstSmallerElement(int arr[]) {
		myStack<Integer> st = new myStack<Integer>();
		int brr[] = new int[arr.length];
		st.push(-1);
		
		int i = arr.length-1;
		while(i>=0) {
			int element = arr[i];
			if(st.peek()<element) {
				brr[i] = st.peek();
				st.push(element);
				i--;
			}
			else {
				int j=0;
				while(st.peek()>element) {
					
					st.pop();
				}
				brr[i] = st.peek();
				st.push(element);
				i--;
			}
		}
		
		return brr;
		
		
	}

}
