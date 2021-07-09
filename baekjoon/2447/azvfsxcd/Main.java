import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static char[][] arr;
	
	private static void map(int n, int x, int y) {
		 if (n == 1){
	            arr[x][y] = '*';
	            return;
	        }
		int n1 = n/3;
		
		for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (i==1 && j==1){
                    continue;
                }
                map(n1, x+n1*i, y+n1*j);
            }
        }
	
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				arr[i][j]=' ';
//			}
//		}
		
		for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], ' ');
        }
		
		map(N,0,0);
		
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}
}
