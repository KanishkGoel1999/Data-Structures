package DSA;

import java.util.Scanner;
import java.util.*;
import HW.myQueue;
import HW.myBinTree.node;
import HW.myStack;

public class BinaryTree_Problems {
	
	//1: zig-zag traversal
	//2: boundary print
	//3: vertical order print
	//4: top view
	//5: bottom view
	//6: left view
	//7: right view
	//8: diagonal view HW
	
	public static void main(String[] args) {
		node root1 = null;
		node root2 = null;
		
		root1 = buildByLevel(root1);
	//	root2 = buildByLevel(root2);

	//	zigZagPrint(root1);
	//	boundaryPrint(root1);
	//	verticalPrint(root1);
		
		topView(root1);
		System.out.println();
		bottomViewPrint(root1);
		System.out.println();
		leftViewPrint(root1);
		System.out.println();
		rightViewPrint(root1);
	}
	
	static void zigZagPrint(node root) {
		myQueue<node> mq = new myQueue<node>();
		myQueue<node> ans = new myQueue<node>();
		myStack<node> st = new myStack<node>();
		mq.enQueue(root);
		mq.enQueue(null);
		
		while(!mq.isEmpty()) {
			node temp = mq.front.data;
			mq.deQueue();
			ans.enQueue(temp);
			
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
				}	}	}
		boolean lr=true;
		while(!ans.isEmpty()) {
			node temp = ans.front.data;
			ans.deQueue();
			
			if(lr) {
				mq.enQueue(temp);
				if(temp==null) {
					lr=false;
				}
			}
			else {
				st.push(temp);
				if(temp==null) {
					lr=true;
				}
			}
		}
		lr=true;
		System.out.println();
		st.pop();
		while(!mq.isEmpty()||!st.isEmpty()) {
			if(lr) {
				node temp = mq.front.data;
				mq.deQueue();
				if(temp!=null) {
					System.out.print(temp.data+" ");
				}
				if(temp==null) {
					System.out.println();
					lr=false;
				}
			}
			else {
				node temp = st.pop();
				if(temp!=null) {
					System.out.print(temp.data+" ");
				}
				else {
					System.out.println();
					lr=true;
				}
			}
			
		}

	}
	
	
	static void boundaryPrint(node root) {
		if(root==null) {
			return;
		}
		node temp = root;
		
		while(temp.left!=null||temp.right!=null) {
			System.out.print(temp.data+" ");
			temp = temp.left;
			if(temp==null) {
				break;
			}
		}
		
		myQueue<node> mq = new myQueue<node>();
		mq = returnLeaf(root, mq);
		while(!mq.isEmpty()) {
			System.out.print(mq.front.data.data+" ");
			mq.deQueue();
		}
		
		temp = root.right;
		myStack<node> st = new myStack<node>();
		while(temp.right!=null||temp.left!=null) {
			st.push(temp);
			temp=temp.right;
			if(temp==null) {
				break;
			}
		}
		
		while(!st.isEmpty()) {
			System.out.print(st.pop().data+" ");
		}
		
	}
	
	static myQueue<node> returnLeaf(node root, myQueue<node> mq) {
		if(root==null) {
			return mq;
		}
		
		
		mq = returnLeaf(root.left, mq);
		if(root.left==null&&root.right==null) {
			mq.enQueue(root);
		}
		mq = returnLeaf(root.right, mq);
		
		return mq;
	}
	
	
	static class group{
		node root;
		int level;
	}
	static class pair{
		int order;
		node node;
	}
	static void verticalPrint(node root) {
		Map<Integer, group> hm = new HashMap<Integer, group>();
		
		if(root==null) {
			return;
		}
		myQueue<pair> mq = new myQueue<pair>();
		pair p = new pair();
		p.order = 0;
		p.node = root;
		mq.enQueue(p);
		
		
		while(!mq.isEmpty()) {
			node temp = mq.front.data.node;
			int order = mq.front.data.order;
			mq.deQueue();
			
			if(temp.left!=null) {
				p.order = order-1;
				p.node = temp.left;
				mq.enQueue(p);
			}
			
			if(temp.right!=null) {
				p.order = order+1;
				p.node = temp.right;
				mq.enQueue(p);
			}
		}	
	}
	
	static Map<Integer, Integer> verticalOrder(node root, int n, Map<Integer, Integer> hm ) {
		
		if(root==null) {
			return hm;
		}
		
		if(!hm.containsKey(n)) {
			hm.put(n, root.data);
		}
		
		hm = verticalOrder(root.left, n-1, hm);
		hm = verticalOrder(root.right, n+1, hm);
		
		return hm;
	}
	
	
	static void topView(node root) {
		Map<Integer, Integer> hm = new HashMap<>();
		hm = verticalOrder(root, 0, hm);
		
		ArrayList<Integer> arr = new ArrayList<>(hm.keySet());
		Collections.sort(arr);
		
		for(int i=0; i<arr.size(); i++) {
			System.out.print(hm.get(arr.get(i))+" ");
		}
		
		
		
	}
	
	static void bottomViewPrint(node root) {
		Map<Integer, Integer> hm = new HashMap<Integer,Integer>();
		hm = getBottomOrder(root, 0, hm);
		
		ArrayList<Integer> arr = new ArrayList<Integer>(hm.keySet());
		Collections.sort(arr);
		
		for(int i=0; i<arr.size(); i++) {
			System.out.print(hm.get(arr.get(i))+" ");
		}
	}
	static Map<Integer, Integer> getBottomOrder(node root, int n, Map<Integer, Integer> hm ) {
			
			if(root==null) {
				return hm;
			}			
		
			hm.put(n, root.data);
			hm = getBottomOrder(root.left, n-1, hm);
			hm = getBottomOrder(root.right, n+1, hm);
			
			return hm;
		}
	
	static Map<Integer,Integer> getLeftOrder(node root, int n, Map<Integer, Integer> hm) {
		if(root==null) {
			return hm;
		}
		
		if(!hm.containsKey(n)) {
			hm.put(n, root.data);
		}
		
		hm = getLeftOrder(root.left, n+1, hm);
		hm = getLeftOrder(root.right, n+1, hm);
		return hm;
	}
	
	static void leftViewPrint(node root) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm = getLeftOrder(root, 0 ,hm);
		ArrayList<Integer> arr = new ArrayList<Integer>(hm.keySet());
		Collections.sort(arr);
		
		for(int i=0; i<arr.size(); i++) {
			System.out.print(hm.get(arr.get(i))+" ");
		}
	}
	
	
	static Map<Integer,Integer> getRightOrder(node root, int n, Map<Integer, Integer> hm) {
		if(root==null) {
			return hm;
		}
		
		hm.put(n, root.data);
		
		
		hm = getRightOrder(root.left, n+1, hm);
		hm = getRightOrder(root.right, n+1, hm);
		return hm;
	}
	
	static void rightViewPrint(node root) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm = getRightOrder(root, 0 ,hm);
		ArrayList<Integer> arr = new ArrayList<Integer>(hm.keySet());
		Collections.sort(arr);
		
		for(int i=0; i<arr.size(); i++) {
			System.out.print(hm.get(arr.get(i))+" ");
		}
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
	
	
}
