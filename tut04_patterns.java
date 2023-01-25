package DSA;

public class tut04_patterns {

	public static void main(String[] args) {
		int n=5;
		
		for(int i=0; i<n; i++) {
			
			int j=1;
			while(j<=n-i) {
				System.out.print(j);
				j++;
			
			}
			int k =0;
			while(k<2*i) {
				System.out.print("*");
				k++;
			}
			j--;
			while(j>0) {
				System.out.print(j);
				j--;
			}
			System.out.println();
		}
	}

}
