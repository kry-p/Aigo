import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int[] min = new int[n];
		for (int i = 0; i < n; i++) {
			min[i] = sc.nextInt();
		}
		Arrays.sort(min);
		int sum =0;
		int[] sumMin=new int[n];
		for (int i = 0; i < n; i++) {
			sum+=min[i];
			sumMin[i]+=sum;
		}
		sum=0;
		for (int i = 0; i < n; i++) {
			sum+=sumMin[i];
		}
		System.out.println(sum);
		
		
		
	}
}
