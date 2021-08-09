import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<Integer>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		int f = 1, q = 1;
//		while(!queue.isEmpty()) {
		while(queue.size()!=1) {
			f = queue.poll();
			
			q = queue.poll();
			queue.add(q);
		}
		
		System.out.println(q);
		
	}
}
