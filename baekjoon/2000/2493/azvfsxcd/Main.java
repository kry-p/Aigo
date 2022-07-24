import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
//		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<Integer>();		// 탑 담을 스택
		Stack<Integer> d = new Stack<Integer>();			// 현재 탑의 인덱스 담을 스택
		
		st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		
		stack.push(a);
		d.push(1);
		sb.append("0 ");	
		
		for(int i=2;i<=N;i++) {			
			int value = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				
				// 스택 최상에 있는 탑의 높이보다 작거나 같은 경우
				if(value <= stack.peek()) {
					sb.append(d.peek() + " ");
					break;
				}
				stack.pop();
				d.pop();
			}
			if(stack.isEmpty()) {
				sb.append("0 ");	
			}
			stack.push(value);
			d.push(i);					
			}
		System.out.println(sb.toString());
    }
}