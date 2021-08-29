import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int x,y;
	static int[] dx= {0,1,1,-1};
	static int[] dy= {1,0,1,1};
	static int win;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[19][19];
		for(int i=0;i<19;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<19;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		test(0,0);
		System.out.println(win);
		if(win!=0) {
			System.out.println(x+" "+y);
		}
	}


	static void test(int a, int b) {
		if(a==18 && b==18) {
			return;
		}
		
		for(int k=0;k<4;k++) {
			int nx= a+dx[k];
			int ny= b+dy[k];
			if(nx>=0 && ny>=0 && nx<19 && ny<19 && arr[a][b]!=0) {
				if(arr[a][b]==arr[nx][ny]) {
					boolean c = true;
					for(int i=1; i<5; i++) {
						int cx = a+(i*dx[k]);
						int cy = b+(i*dy[k]);
						if(cx<0 || cy<0 || cx>=19 || cy>=19 || arr[nx][ny]!=arr[cx][cy]) {
							c=false;
						}
					}
					if(a+5*dx[k]>=0 && b+5*dy[k]>=0 && a+5*dx[k]<19 && b+5*dy[k]<19 && arr[a][b]==arr[a+5*dx[k]][b+5*dy[k]] 
							|| a+(-1)*dx[k]>=0 && b+(-1)*dy[k]>=0 && a+(-1)*dx[k]<19 && b+(-1)*dy[k]<19 && arr[a][b]==arr[a+(-1)*dx[k]][b+(-1)*dy[k]]) {
						c=false;
					}
					if(c==true) {
						x = a+1;
						y = b+1;
						win = arr[a][b];
						return;
					}
				}
			}
		}
		if(b<18) {
			test(a,b+1);
		}
		else if(b==18){
			test(a+1,0);
		}
		
	}
}

	/*
	static int R, C;
	static int[][] board;
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    board = new int[19][19];
	    
	    StringTokenizer token;
	    for(int i = 0; i < 19; i++) {
	        token = new StringTokenizer(br.readLine());
	        for (int j = 0; j < 19; j++) {
	            board[i][j] = Integer.parseInt(token.nextToken());
	        }
	    }
	    
	    for (int i = 0; i < 19; i++) {
	        for (int j = 0; j < 19; j++) {
	            if(board[i][j] != 0) {
	                for(int k = 0; k < 4; k++) {
	                    if(dfs(i, j, 0, board[i][j], k)) {
	                        winR = i;
	                        winC = j;
	                    }
	                }
	            }
	        }
	    }

	    winR++;
	    winC++;
	    System.out.println(whoWin != 0 ? whoWin + "\n" + winR + " " + winC : 0);
	}

	static int whoWin = 0; // 검 1, 흰 2
	static int[] dc = {1, 1, 1, 0}; // 우상, 우, 우하, 하
	static int[] dr = {-1, 0, 1, 1};
	static int winR = -1, winC = -1;
	
	static boolean dfs(int r, int c, int cnt, int who, int dir) {
	    int nr = r + dr[dir];
	    int nc = c + dc[dir];
	    if(nr < 0 || nr >= 19 || nc < 0 || nc >= 19) return false;
	    
	    if(cnt == 4) {
	        if(board[nr][nc] == who) return false;
//	        if (c+(-5)*dc[dir]>=0 && r+(-5)*dr[dir]>=0 && c+(-5)*dc[dir]<19 && r+(-5)*dr[dir]<19 && board[c][r]==board[c+(-5)*dc[dir]][r+(-5)*dr[dir]])
//	        	return false;
//	        if(dfs(r - 5*dr[dir], c - 5*dc[dir], cnt-4, who, dir)) return false;    
	        whoWin = who;
	        return true;
	    }
	    
	    if(board[nr][nc] != who) return false;
	    
	    if(dfs(nr, nc, cnt + 1, who, dir)) return true;    
	    return false;
	}
}
	 */
