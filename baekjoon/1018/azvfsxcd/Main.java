import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		for(int i=0; i<N;i++) {
			arr[i] = br.readLine().toCharArray();
		}
//		System.out.println(Arrays.toString(arr[0]));
		int min=100;
		for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
				int cnt=0;
				int cnt1=0;
				for(int k=i;k<i+8;k++) {
					for (int l = j; l < j+8; l++) {
						if(k%2==0) {
							if(l%2==0) {
								if(arr[k][l]=='B')	cnt++;
							}
							else {
								if(arr[k][l]=='W')	cnt++;
							}
						}
						else {	//홀수
							if(l%2==0) {
								if(arr[k][l]=='W')	cnt++;
							}
							else {
								if(arr[k][l]=='B')	cnt++;
							}
						}
					}
				}
				for(int k=i;k<i+8;k++) {
					for (int l = j; l < j+8; l++) {
						if(k%2==0) {
							if(l%2==0) {
								if(arr[k][l]=='W')	cnt1++;
							}
							else {
								if(arr[k][l]=='B')	cnt1++;
							}
						}
						else {	//홀수
							if(l%2==0) {
								if(arr[k][l]=='B')	cnt1++;
							}
							else {
								if(arr[k][l]=='W')	cnt1++;
							}
						}
					}
				}
				if(min>cnt) {
					min = cnt;
				}
				if(min>cnt1) {
					min = cnt1;
				}
			}

		}
		System.out.println(min);
	
	}
}
/*
8 9
BBBBBBBBB
BBBBBBBBB
BBBBBBBBB
BBBBBBBBB
BBBBBBBBB
BBBBBBBBB
BBBBBBBBB
BBBBBBBBW
 */
