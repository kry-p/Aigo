import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
//	static int[] dx = { 1, -1, -1, 1 };
//	static int[] dy = { 1, 1, -1, -1 };
	static int t;
	static int w;
	static int h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		w = Integer.parseInt(st.nextToken());			// 맵크기
		h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());		// 개미 첫 위치
		int q = Integer.parseInt(st.nextToken());
		
		t = Integer.parseInt(br.readLine());			// 이동 시간

		int x=p;
		int y=q;
		
		x += t;
		y += t;
		
		x %= (2*w);
		y %= (2*h);
		
		if(x > w) x = 2 * w - x;
		if(y > h) y = 2 * h - y;
		
		sb.append(x).append(" ").append(y);
		
		System.out.println(sb);
		
		
		
//		boolean ax = false, ay = false;
//		int test=0;
//		for(int i =0; i<t; i++) {
//			if(x==w) {
//				ax= true;
//			}
//			if(y==h) {
//				ay= true;
//			}
//			if(x==0) {
//				ax = false;
//			}
//			if(y==0) {
//				ay = false;
//			}
		
//			if(ax == false) {
//				x++;
//			}
//			else {
//				x--;
//			}
//			if(ay == false) {
//				y++;
//			}
//			else {
//				y--;
//			}
//			
//		}
//		
//		System.out.println(x + " " + y);
	}
}
