package DSA;
import HW.myBinTree.node;
import HW.myQueue;
import java.util.*;

public class BinaryTree_HardProblems {
	
	//1: construct tree from inorder and preorder
	//2: construct tree from inorder and postorder
	public static void main(String[] args) {
		myQueue<Integer> in = new myQueue<Integer>();
		myQueue<Integer> p = new myQueue<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter in size ");
		int i = sc.nextInt();
		buildQueue(i-1, in);
		System.out.println("Enter pre size ");
		int j = sc.nextInt();
		buildQueue(j-1 , p);
		
		//node root = buildByInPre(in , p);
		//postOrder(root);
		node root = buildByInPost(in, p);
		preOrder(root);
	}
	
	static void buildQueue(int i, myQueue<Integer> mq) {
		Scanner sc = new Scanner(System.in);
		while(i>=0) {
			mq.enQueue(sc.nextInt());
			i--;
		}
	}
	
	static node buildByInPre(myQueue<Integer> in, myQueue<Integer> pre) {
		if(pre.front==null || in.front==null) {
			return null;
		}
		node root = new node(pre.front.data);
		pre.deQueue();
		
		myQueue<Integer> leftIn = new myQueue<Integer>();
		
		while(in.front.data!=root.data) {
			leftIn.enQueue(in.front.data);
			in.deQueue();
		}
		in.deQueue();
		
		root.left = buildByInPre(leftIn, pre);
		root.right = buildByInPre(in, pre);
		
		return root;
	}

	static node buildByInPost(myQueue<Integer> in, myQueue<Integer> post) {
		if(in.front==null || post.front==null) {
			return null;
		}
		
		node root = new node(post.rear.data);
		
		myQueue<Integer> leftIn = new myQueue<Integer>();
				
		while(in.front.data!=root.data) {
			leftIn.enQueue(in.front.data);
			in.deQueue();
		}
		in.deQueue();
		
		while(post.front.data!=root.data) {
			post.enQueue(post.front.data);
			post.deQueue();
		}
		post.deQueue();
		
		root.right = buildByInPost(in, post);
		root.left = buildByInPost(leftIn, post);
		
		return root;
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
}
