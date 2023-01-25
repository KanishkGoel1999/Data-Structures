package DSA;

import java.util.ArrayList;
import java.util.Scanner;
import HW.myBinTree.node;
import HW.myQueue;
import HW.myBinTree.node;

public class BinarySearchTree_Merge {
	
	//merge 2 BSTs
	public static void main(String[] args) {
		node root = null;
		myQueue<Integer> mq = new myQueue<Integer>();
		mq = takeData(mq);
		root = preOrderToBst(mq, Integer.MIN_VALUE, Integer.MAX_VALUE);
		levelOrderPrint(root);
		node root1 = null;
		mq = takeData(mq);
		root1 = preOrderToBst(mq, Integer.MIN_VALUE, Integer.MAX_VALUE);
		levelOrderPrint(root1);
		
		root = merge2Bst(root, root1);
		levelOrderPrint(root);
	}
	
	
	// to optimize space, use app2 -> flatten trees into LL 
	static node merge2Bst(node root1, node root2) {
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr = getInOrder(root1, arr);
		ArrayList<Integer> brr = new ArrayList<Integer>();
		brr = getInOrder(root2, brr);
		ArrayList<Integer> crr = new ArrayList<Integer>();
		int a=0, b=0;
		
		//merge both inOrders
		while(a<arr.size() && b<brr.size()) {
			if(arr.get(a) <= brr.get(b)) {
				crr.add(arr.get(a));
				a++;
			}
			else {
				crr.add(brr.get(b));
				b++;
			}
		}
		while(a<arr.size()) {
			crr.add(arr.get(a));
			a++;
		}
		while(b<brr.size()) {
			crr.add(brr.get(b));
			b++;
		}
		
		//inOrder to BST
		node root = inOrderToBst(crr, 0, crr.size()-1);
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
	
	static ArrayList<Integer> getInOrder(node root, ArrayList<Integer> arr) {
		if(root==null) {
			return arr;
		}
		getInOrder(root.left, arr);
		arr.add(root.data);
		getInOrder(root.right, arr);
		
		return arr;
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
