import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static char[][] arr;
	
	private static void map(int i_start, int i_end, int j) {
		if (i_end - i_start == 2) { // 삼각형 그리기
			arr[i_start][j] = '*';
			arr[i_start+1][j-1] = '*';
			arr[i_start+1][j+1] = '*';
			arr[i_start+2][j-2] = '*';
			arr[i_start+2][j-1] = '*';
			arr[i_start+2][j] = '*';
			arr[i_start+2][j+1] = '*';
			arr[i_start+2][j+2] = '*';
			return;
			} else if (i_start < i_end) { // 3등분 나누기 
				int i_length = (i_end - i_start) / 2;
				int j_length = (i_end - i_start +1) / 2;
				map(i_start, i_start + i_length, j);
				map(i_start + i_length + 1, i_end, j-j_length);
				map(i_start + i_length + 1, i_end, j+j_length); 
			}
	
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N/3*6-1];

		for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], ' ');
        }
		int start=((N/3)*6-1)/2;
		map(0,N-1,start);
		
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}
}
