package DSA;
import HW.randomLL;
import HW.randomLL.node;
import java.util.HashMap;
import java.util.Map;


public class LinkedList_CloneList {

	public static void main(String[] args) {
		randomLL<Integer> oll = new randomLL<Integer>();
		oll.add(2);
		oll.add(4);
		oll.add(7);
		oll.add(9);
		oll.add(13);
		node<Integer> temp = oll.head;
		while(temp!=null && temp.next!=null) {
			temp.random = temp.next.next;
			temp=temp.next;
		}
		oll.print();
		//randomLL<Integer> cll = cloneApp1(oll);
//		int a=cll.head.next.random.data;
//		System.out.println(a);
//		
		randomLL<Integer> cll = cloneApp2(oll);
		int a=cll.head.next.random.data;
		System.out.println(a);
		
		
		
	}
	
	static randomLL<Integer> cloneApp1(randomLL<Integer> oll){
		
		randomLL<Integer> cll = new randomLL<Integer>();
		Map<node<Integer>, node<Integer>> hm = new HashMap<node<Integer>, node<Integer>>();
		cll.add(oll.head.data);
		node<Integer> oTemp = oll.head.next;
		node<Integer> cTemp = cll.head;
		while(oTemp!=null) {
			cll.add(oTemp.data);
			hm.put(oTemp, cTemp);
			cTemp = cTemp.next;
			oTemp = oTemp.next;	
		}
		
		cTemp = cll.head;
		oTemp = oll.head;
		
		while(oTemp!=null) {
			node<Integer> t = oTemp.random;
			t = hm.get(t);
			cTemp.random = t;
			oTemp = oTemp.next;
			cTemp = cTemp.next;
		}
		
		return cll;
	}
	
	static randomLL<Integer> cloneApp2(randomLL<Integer> oll){
		randomLL<Integer> cll = new randomLL<Integer>();
		
		node<Integer> oTemp = oll.head;
		node<Integer> cTemp = cll.head;
		node<Integer> t = oTemp;
		
		while(oTemp!=null) {
			cll.add(oTemp.data);
			oTemp = oTemp.next;
		}
		
		oTemp = oll.head;
		
		while(oTemp!=null && cTemp!=null) {
			oTemp = oTemp.next;
			t.next = cTemp;
			t = cTemp.next;
			cTemp.next = oTemp;
			cTemp = t;
			t = oTemp;
		}
		t=oll.head;
		while(t.next!=null) {
			t.next.random = t.random.next;
			t=t.next.next;
		}
		
		t = oll.head;
		oTemp = oll.head;
		cTemp = cll.head;
		
		while(oTemp!=null && cTemp!=null) {
			oTemp.next = cTemp.next;
			oTemp = oTemp.next;
			if(oTemp==null) {
				break;
			}
			cTemp.next = oTemp.next;
			cTemp = cTemp.next;
		}
		 return cll;
		
		
	}

}
