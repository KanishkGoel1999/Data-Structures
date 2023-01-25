package DSA;
import java.util.Scanner;
import HW.myStack;
import HW.myBinTree;
import HW.myBinTree.node;
import HW.myQueue;


public class Trees_Abstract {

	//1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
	
	//					1
	//			3			5
	//		   7 11		  17
	// inOrder=    7 3 11 1 17 5
	// preOrder=   1 3 7 11 5 17
	// postOrder=  7 11 3 17 5 1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node root = null;
		//root = buildTree(root);
		//reverseLevelOrderPrint(root);
		root = buildByLevel(root);
		levelOrderPrint(root);
		
//		inOrder(root);
//		System.out.println();
//		preOrder(root);
//		System.out.println();
//		postOrder(root);
		
		System.out.println(noOfLeafNodes(root, 0));
		
		
	}
	
	
	
	static node buildTree(node root) {
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		root = new node(data);
		
		if(data==-1) {
			return null;
		}
		
		System.out.println("enter left of "+ data);
		root.left = buildTree(root.left);
		System.out.println("enter right of "+ data);
		root.right = buildTree(root.right);
		return root;
	}

	static node buildByLevel(node root) {
		myQueue<node> mq = new myQueue<node>();
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		root = new node(data);
		mq.enQueue(root);
		
		while(!mq.isEmpty()) {
			node temp = mq.front.data;
			mq.deQueue();
			
			
			System.out.println("enter left of "+temp.data);
			int l = sc.nextInt();
			if(l!=-1) {
				temp.left = new node(l);
				mq.enQueue(temp.left);
			}

			System.out.println("enter right of "+temp.data);
			int r = sc.nextInt();
			if(r!=-1) {
				temp.right = new node(r);
				mq.enQueue(temp.right);
			}
			
		}
		return root;
	}
	
	
	
	static void levelOrderPrint(node root) {
		//breadth first traversal
		
		myQueue<node> mq = new myQueue<node>();
		mq.enQueue(root);
		mq.enQueue(null);
		
		while(!mq.isEmpty()) {
			node temp = mq.front.data;
			mq.deQueue();
			
			if(temp==null) {
				System.out.println();
				if(!mq.isEmpty()) {
					mq.enQueue(null);
				}
			}
			else {
				System.out.print(temp.data+" ");
				if(temp.left!=null) {
					mq.enQueue(temp.left);
				}
				
				if(temp.right!=null) {
					mq.enQueue(temp.right);
				}	}	}	}
	
	
	static void reverseLevelOrderPrint(node root) {

		myStack<Integer> st = new myStack<Integer>();
		myQueue<node> mq = new myQueue<node>();
		mq.enQueue(root);
		mq.enQueue(null);
		
		
		while(!mq.isEmpty()) {
			node temp = mq.front.data;
			mq.deQueue();
			
			if(temp==null) {
				st.push(-1);
				System.out.println();
				if(mq.isEmpty()) {
					mq.enQueue(null);
				}
			}
			else {
				st.push(temp.data);
				System.out.print(temp.data+" ");
				if(temp.left!=null) {
					mq.enQueue(temp.left);
				}
				
				if(temp.right!=null) {
					mq.enQueue(temp.right);
				}	}	}
		System.out.println();
		reverseStack(st);
		st.print();		
	
	}
	
	static void inOrder(node root) {
		if(root==null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+"  ");
		inOrder(root.right);
	}
	
	static void preOrder(node root) {
		if(root==null) {
			return;
		}
		
		System.out.print(root.data+"  ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	static void postOrder(node root) {
		if(root==null) {
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+"  ");
	}
	
	static int noOfLeafNodes(node root, int cnt) {
		if(root==null) {
			return cnt;
		}
		if(root.left==null&&root.right==null) {
			cnt++;
		}
		cnt = noOfLeafNodes(root.left, cnt);
		cnt = noOfLeafNodes(root.right, cnt);
		
		return cnt;
	}
	
	
	
	
	
	
	
	
	
	static void reverseStack(myStack<Integer> st) {
		if(st.isEmpty()||st.peek()==-1) {
			
			if(st.isEmpty()) {
				return;
			}
			else {
				int ele = st.pop();
				reverseStack(st);
				st.push(ele);
				return;}
		}
		
		int element = st.pop();
		reverseStack(st);
		insertAtBottom(st, element);
	}
	
	static void insertAtBottom(myStack<Integer> st ,int n) {
		if(st.isEmpty()||st.peek()==-1) {
			st.push(n);
			return;
		}
		
		int element = st.pop(); // 7 9 2 5 3
		insertAtBottom(st, n);
		st.push(element);
		
	}
	
	

}
