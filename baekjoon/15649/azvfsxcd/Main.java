import java.util.Arrays;
import java.util.Scanner;


public class Main {

	static int[] numbers;
	static int NUM;
	static boolean[] isSelected;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		numbers = new int[N];
		isSelected = new boolean[N+1];
		NUM = N;
		
		test(0);
	}
	
	public static void test(int num) {
		if(NUM==num) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i =1; i< NUM; i++) {
			if(isSelected[i]) continue;
			
			numbers[num] = i;
			isSelected[i]=true;
			
			test(num+1);
			isSelected[i]= false;
		
			
		}
	}
	
}
