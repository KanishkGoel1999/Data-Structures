package DSA;
import HW.myStack;
import java.util.*;


public class Stack_Reverse {
	//1: redundant bracket
	//2: sorted insert
	//3: sort stack
	//4: reverse stack
	//5: valid parenthesis
	public static void main(String[] args) {
		String s = "Kani";
		//System.out.println(reverse(s));
		myStack<Integer> st = new myStack<Integer>();
		st.push(3);
		st.push(5);
		st.push(2);
		st.push(9);
		st.push(7);
		
//		st.print();
//		removeMiddle(st, st.size(), 0);
//		
		st.print();
		
//		String sa = "[[{{()}}]]{}";
//		validParanthesis(sa);
//		insertAtBottom(st, 11);
//		st.print();
		reverseStack(st);
		st.print();
		sortStack(st);
		st.print();
		
		String exp = "(a+b)+((c-d))";
		System.out.println(redundantBracket(exp));
		
		Stack<Integer> stt = new Stack<Integer>();
		
	}
	
	static boolean redundantBracket(String s) {
		
		int cnt = 0;
		myStack<Character> st = new myStack<Character>();
		
		
		while(cnt>s.length()) {
			char c = s.charAt(cnt);
			if(c=='(' || c=='+' || c=='-' || c=='*' || c=='/') {
				st.push(c);
				cnt++;
			}
			else if(c==')'){
				int i=0;
				while(st.peek()!='(') {
					st.pop();
					i++;
				}
				if(i==0) {
					return true;
				}
				else {
				st.pop();
				cnt++;}
			}
			else {
				cnt++;
			}
		}
		
		return false;
	}
	
	static void sortedInsert(myStack<Integer> st, int n) {
		if(st.isEmpty()) {
			st.push(n);
			return;
		}
		else if(st.peek()>n) {
			int element = st.pop();
			sortedInsert(st, n);
			st.push(element);
		}
		else {
			st.push(n);
		}
		

		
	}
	static void sortStack(myStack<Integer> st) {
		if(st.isEmpty()) {
			return;
		}
		
		int element = st.pop(); // 7 9 2 5 3
		sortStack(st);
		sortedInsert(st, element);
	}
	
	static void reverseStack(myStack<Integer> st) {
		if(st.isEmpty()) {
			return;
		}
		
		int element = st.pop();
		reverseStack(st);
		insertAtBottom(st, element);
	}
	
	static void validParanthesis(String s) {
		myStack<Character> st = new myStack<Character>();
		int cnt = 0;
		
		while(cnt<s.length()) {
			if(st.isEmpty()) {
				st.push(s.charAt(cnt));
				cnt++;
			}
			
			else if(st.peek()=='[') {
				if(s.charAt(cnt)==']') {
					st.pop();
					cnt++;
				}
				else {
					st.push(s.charAt(cnt));
					cnt++;
				}
			}
			else if(st.peek()=='{') {
				if(s.charAt(cnt)=='}') {
					st.pop();
					cnt++;
					
				}
				else {
					st.push(s.charAt(cnt));
					cnt++;
				}
			}
			else {
				if(s.charAt(cnt)==')') {
					st.pop();
					cnt++;
				}
				else {
					st.push(s.charAt(cnt));
					cnt++;
				}
			}
		}
		
		
		
		if(st.isEmpty()) {
			System.out.println("Valid paranthesis");
		}
		else {
			System.out.println("Invalid paranthesis");
		}
	}
	
	static void insertAtBottom(myStack<Integer> st ,int n) {
		if(st.isEmpty()) {
			st.push(n);
			return;
		}
		
		int element = st.pop(); // 7 9 2 5 3
		insertAtBottom(st, n);
		st.push(element);
		
	}
	
	static void removeMiddle(myStack<Integer> st, int size, int count) {
		if(count==size/2) {
			st.pop();
			return;
		}
		
		int element = st.pop();
		count++;
		removeMiddle(st, size, count);
		st.push(element);
		
		
		
	}
	
	static String reverse(String s) {
		myStack<Character> st = new myStack<Character>();
		int length = s.length();
		for(int i=0; i<length; i++){	
			st.push(s.charAt(i));
		}
		
		s = "";
		
		for(int i=0; i<length; i++) {
			s = s + st.pop();
		}
		
		return s;
	}

}
