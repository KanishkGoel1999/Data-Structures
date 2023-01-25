package DSA;
import java.util.Scanner;
import HW.myQueue;
import HW.myBinTree.node;
import HW.myBinTree.pair;

public class BinaryTree_Problems {

	//1: height of bin tree
	//2: diameter -> longest path b/t 2 end nodes
	//3: isBalanced
	//4: areIndentical
	//5: sumTree
	public static void main(String[] args) {
		node root1 = null;
		node root2 = null;
		
		root1 = buildByLevel(root1);
	//	root2 = buildByLevel(root2);
		
//		System.out.println(height(root1));
//		System.out.println();
//		System.out.println(diameter(root1).b);
//		System.out.println(isBalanced(root1).b);
//		System.out.println();
//		System.out.println(areIdentical(root1, root2));
//		
		System.out.println(sumTree(root1).b);
		
		
	}

	static int height(node root) {

		int height = 0;
		if(root==null) {
			return height;
		}
		int hl = height(root.left);
		int hr = height(root.right);
		
		height=Integer.max(hl, hr)+1; // add height of root
		return height;
		
	}
	
	static pair<Integer,Integer> diameter(node root) {
		
		if(root==null) {
			pair<Integer,Integer> dim = new pair<Integer,Integer>();
			dim.b=0;
			dim.h=0;
			return dim;
		}
		
		pair<Integer,Integer> dim = new pair<Integer,Integer>();
		pair<Integer,Integer> dimL = diameter(root.left);
		pair<Integer,Integer> dimR = diameter(root.right);
		
		int op3 = dimL.h + dimR.h + 1;
		dim.h =Integer.max(dimL.h, dimR.h)+1;
		
		dim.b = Integer.max(Integer.max(dimL.b, dimR.b), op3);
		
		return dim;
	}
	
	
	static pair<Boolean,Integer> isBalanced(node root){
		if(root==null) {
			pair<Boolean,Integer> p = new pair<Boolean,Integer>();
			p.b = true;
			p.h = 0;
			return p;
		}
		pair<Boolean,Integer> ans = new pair<Boolean,Integer>();
		ans.b = false;
		pair<Boolean,Integer> left = isBalanced(root.left);
		pair<Boolean,Integer> right = isBalanced(root.right);
		boolean op1 = false;
		
		int hl = left.h;
		int hr = right.h;
		if(hl-hr<=1 && hl-hr>=-1) {
			op1 = true;
		}
		
		ans.h = Integer.max(hl, hr) + 1;
		ans.b = left.b && right.b && op1;
		
		return ans;
	}
	
	static boolean areIdentical(node root1, node root2) {
		
		if(root1==null && root2==null) {
			return true;
		}
		if(root1==null && root2!=null) {
			return false;
		}
		if(root1!=null && root2==null) {
			return false;
		}
		
		boolean ans = false;
		if(root1.data==root2.data) {
			ans = true;
		}
		boolean left = areIdentical(root1.left, root2.left);
		boolean right = areIdentical(root1.right, root2.right);
		ans = left && right && ans;
				
		return ans;
	}
	
	static pair<Boolean,Integer> sumTree(node root){
		pair<Boolean,Integer> ans = new pair<Boolean,Integer>();
		if(root==null) {
			ans.b = true;
			ans.h = 0;
			return ans;
		}
		if(root.left==null && root.right==null) {
			ans.b=true;
			ans.h=root.data;
			return ans;
		} 

		pair<Boolean, Integer> leftS = sumTree(root.left);
		pair<Boolean, Integer> rightS = sumTree(root.right);
		
		ans.h = root.data + leftS.h + rightS.h;
		
		if(leftS.b==false||rightS.b==false) {
			ans.b  = false;
			
			return ans;
		}
		
		if(root.data != leftS.h + rightS.h) {
			ans.b = false;
			return ans;
		}
		else {
			ans.b = true;
			return ans;
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
