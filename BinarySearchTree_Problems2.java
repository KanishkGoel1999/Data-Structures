package DSA;
import java.util.*;
import HW.myBinTree.node;

import java.util.Scanner;

import HW.myQueue;


public class BinarySearchTree_Problems2 {
	
	//1: two sum
	//2: flatten LL
	//3: normal to balanced
	//4: preorder to BST
	public static void main(String[] args) {
		
		node root = null;
		//root = takeInput(root);
//		boolean ans = twoSum(root, 20);
//		System.out.println(ans);
//		node temp = flattenLL(root);
//		while(temp!=null) {
//			System.out.print(temp.data+ " ");
//			temp = temp.right;
//		}
		
//		root = normalToBalanced(root);
		myQueue<Integer> mq = new myQueue<Integer>();
		mq = takeData(mq);
		root = preOrderToBst(mq, Integer.MIN_VALUE, Integer.MAX_VALUE);
		levelOrderPrint(root);
	}
	
	static myQueue<Integer> takeData(myQueue<Integer> mq) {
		Scanner sc = new Scanner(System.in);
		int data  = sc.nextInt();
		while(data!=-1) {
			mq.enQueue(data);
			data = sc.nextInt();	
		}
		return mq;
	}
	//app1: simple take input and build  T = O(n^2)
	//app2: get inorder and make a BST with in and pre  T = O(nlogn)
	//app3: 
	static node preOrderToBst(myQueue<Integer> mq, int min, int max) {
		
		if(mq.isEmpty()) {
			return null;
		}
		int element = mq.front.data;
		
		
		if(element>max || element<min) {
			return null;
		}
		mq.deQueue();
		node root = new node(element);
		root.left = preOrderToBst(mq, min, element);
		root.right = preOrderToBst(mq, element, max);
		
		return root;
		
	}
	
	
	static node normalToBalanced(node root) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		getInOrder(root,arr);
		root = inOrderToBst(arr, 0, arr.size()-1);
		
		return root;
	}
	
	static node inOrderToBst(ArrayList<Integer> arr, int s, int e){
		int mid = (s+e)/2;
		if(s>e) {
			return null;
		}
		node root = new node(arr.get(mid));
		root.left = inOrderToBst(arr, s, mid-1);
		root.right = inOrderToBst(arr, mid+1, e);
		return root;
		
	}
	
	static node flattenLL(node root) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		getInOrder(root, arr);
		
		int i=0;
		root = new node(arr.get(i));
		node curr = root;
		i++;
		while(i<arr.size()) {
			node temp = new node(arr.get(i));
			curr.left = null;
			curr.right = temp;
			curr = temp;
			i++;
		}
		curr.right = null;
		return root;
	}
	
	static boolean twoSum(node root, int k) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		//store inOrder
		getInOrder(root, arr);
		
		//use 2 pointer approach
		int i=0;
		int j=arr.size()-1;
		while(i<=j) {
			int sum = arr.get(i) + arr.get(j);
			if(sum==k) {
				return true;
			}
			else if(sum<k) {
				i++;
			}
			else {
				j--;
			}
		}
		
		return false;
	}
	
	
	
	static ArrayList<Integer> getInOrder(node root, ArrayList<Integer> arr) {
		if(root==null) {
			return arr;
		}
		getInOrder(root.left, arr);
		arr.add(root.data);
		getInOrder(root.right, arr);
		
		return arr;
	}
	
	static node takeInput(node root) {
		Scanner sc = new Scanner(System.in);
		int data  = sc.nextInt();
		while(data!=-1) {
			root = insertIntoBST(root, data);
			data = sc.nextInt();	
		}
		return root;
	}
	static node insertIntoBST(node root, int data) {
		if(root==null) {
			root = new node(data);
			return root;
		}
		
		else if(root.data>=data) {
			root.left = insertIntoBST(root.left, data);
		}
		else {
			root.right = insertIntoBST(root.right, data);
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

}
