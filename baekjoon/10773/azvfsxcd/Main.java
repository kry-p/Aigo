import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			if(a!=0) {
				stack.push(a);
			}
			else {
				stack.pop();
			}
		}
		
		
		int sum = 0;
		while(!stack.isEmpty()) {
			sum+= stack.pop();
		}
		System.out.println(sum);
		
		
	}
}
