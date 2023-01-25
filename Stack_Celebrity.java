package DSA;
import HW.myStack;

public class Stack_Celebrity {

	public static void main(String[] args) {
		
		int arr[][] = {{0,1,0},
						{0,0,0},
						{0,1,0}};
		System.out.println(celebrity(arr));
						
		

	}

	static boolean celebrity(int arr[][]) {
		
		myStack<Integer> st = new myStack<Integer>();
		for(int i=0; i<arr.length; i++) {
			st.push(i);
		}
		int a=0;
		int b=a;
		while(st.size()>1) {
			a = st.pop();
			b = st.pop();
			if(arr[a][b]==1) {
				st.push(b);
			}
			
			if(arr[b][a]==1) {
				st.push(a);
			}
		}
		
		b=st.pop();
		for(int i=0; i<arr.length; i++) {
			if(i!=b && arr[i][b]==0) {
				return false;
			}
			
		}
		
		for(int i=0; i<arr[0].length; i++) {
			if(i!=b && arr[b][i]==1) {
				return false;
			}
		}
		
		return true;
		
	}
}
