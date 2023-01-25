package DSA;
import java.util.Scanner;
import HW.myQueue;
import HW.myBinTree.node;
import DSA.tut69_binarySearchTree;;

public class BinarySearchTree_Problems1 {
	//1: isBST
	//2: kTh small/large
	//3: pred/succ in inorder
	//4: LCA
	public static void main(String[] args) {
		node root = new node(0);
		root = takeInput(root);
		//System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println();
		myQueue<Integer> mq = new myQueue<Integer>();
		myQueue<Integer> nq = new myQueue<Integer>();
		inOrderPrint(root);
		System.out.println();
		predSucc(root, 3);
		System.out.println(LCA(root, 1, 3).data);;
	}
	
	//app1- get inorder, if its sorted then BST
	//app2- check range
	static boolean isBST(node root, int i, int j) {
		//base case
		if(root==null) {
			return true;
		}
		boolean ans = false;
		
		//condition
		if(root.data<=j && root.data>=i) {
			ans = true;
			//recursive call
			ans = isBST(root.left, i, root.data);
			ans = isBST(root.right, root.data, j);
		}
		
		return ans;
	}
	
	//traverse inorder and increment i
	// make call stack
	static int kThSmallest(node root, int i, int k) {
		if(root==null) {
			return -1;
		}
		
		
		int left = kThSmallest(root.left, i, k);
		if(left!=-1) {
			return left;
		}
		
		i++;
		if(i==k) {
			return root.data;
		}
		
		return kThSmallest(root.right, i ,k);
		
	}
	
	// i = size-i+1
	static int kThLargest(node root, int i, int k) {
		if(root==null) {
			return -1;
		}
		
		
		int left = kThSmallest(root.left, i, k);
		if(left!=-1) {
			return left;
		}
		
		i++;
		if(i==k) {
			return root.data;
		}
		
		return kThSmallest(root.right, i ,k);	
		
	}
	
	//app1: store inorder in array and print
	//app2: pred is max in left subtree
	//		succ is min in right subtree
	static void inOrderPred(node root, int k) {
		if(root==null) {
			return;
		}
		
		inOrderPred(root.left, k );
		
		
		if(root.data==k) {
			node temp = getMax(root.left);
			if(temp==null) {
				System.out.println("There is no predessor!");
				return;
			}
			System.out.println(" predecessor is "+ temp.data);
			temp = getMin(root.right);
			if(temp==null) {
				System.out.println("There is no successor!");
				return;
			}
			System.out.println(" suuccesssor is "+ temp.data);
			return;
		}
		
		inOrderPred(root.right, k);
		
	}
	
	static void predSucc(node root, int k) {
		if(root==null) {
			return;
		}
		
		node temp = root;
		int pred = 0;
		int succ = 0;
		while(temp.data!=k) {
			if(temp.data<k) {
				pred = temp.data;
				temp = temp.right;
			}
			else {
				succ= temp.data;
				temp = temp.left;
			}
		}
		
		node predNode = getMax(temp.left);
		node succNode = getMax(temp.right);
		
		if(predNode!=null) {
			pred = predNode.data;
		}
		
		if(succNode!=null) {
			succ = succNode.data;
		}
		
		System.out.println("The pred is "+ pred);
		System.out.println("The succ is "+ succ);
	}
	
	static node LCA(node root, int a, int b) {
		if(root==null) {
			return null;
		}
		
		if(root.data<a && root.data<b) {
			return LCA(root.right, a, b);
		}
		if(root.data>a && root.data>b) {
			return LCA(root.left, a, b);
		}
		
		if(root.data>a && root.data<b) {
			return root;
		}
		
		if(root.data<a && root.data>b) {
			return root;
		}
		return root;
	}
	
	
	static void inOrderPrint(node root) {
		if(root==null) {
			return;
		}
		
		inOrderPrint(root.left);
		
		System.out.print(root.data + " ");
		
		inOrderPrint(root.right);
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

}
