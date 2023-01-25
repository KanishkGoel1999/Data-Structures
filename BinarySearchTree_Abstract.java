package DSA;
import HW.myBinTree.node;
import java.util.*;
import HW.myQueue;

public class BinarySearchTree_Abstract {
	//for every node leftData< nodeData < rootData
	//build
	//insert
	//getMin getMax
	//deletion
	// in order is always sorted
	public static void main(String[] args) {

		myQueue<Integer> mq = new myQueue<Integer>();
		node root = takeInput(null);
		levelOrderPrint(root);
//		System.out.println(search(root, 3));
//		System.out.println(search(root, 30));
//		System.out.println();
//		System.out.println("min is " + getMin(root).data +" and max is "+ getMax(root).data);
		deletion(root, 50);
		levelOrderPrint(root);

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
	
	//T.C = (logn)
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
	
	
	static boolean search(node root, int data) {
		if(root==null) {
			return false;
		}
		if(root.data==data) {
			return true;
		}
		if(root.data>data) {
			return search(root.left, data);
		}
		else {
			return search(root.right, data);
		}
	}
	
	static node getMin(node root) {
		if(root==null) {
			return null;
		}
		
		if(root.left==null) {
			return root;
		}
		
		return getMin(root.left);
		
	}
	static node getMax(node root) {
		if(root==null) {
			return null;
		}
		
		if(root.right==null) {
			return root;
		}
		
		return getMax(root.right);
	}
	
	
	static node deletion(node root, int x) {
		//base case
		if(root==null) {
			return root;
		}
		
		if(root.data==x) {
			//0 child
			if(root.left==null && root.right==null) {
				return null;
			}
			//1 child -> left
			else if(root.left!=null && root.right==null) {
				return root.left;
			}
			//1 child -> right 
			else if(root.left==null && root.right!=null) {
				return root.right;
			}
			//2 child
			else {
				int y = getMax(root.left).data;
				root.data = y;
				root.left = deletion(root.left, y);
				return root;
			}
		}
		else if(root.data>x) {
			root.left = deletion(root.left, x);
		}
		else {
			root.right = deletion(root.right, x);
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
