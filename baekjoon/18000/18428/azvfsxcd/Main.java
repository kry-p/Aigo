package algoStudy01;

import java.util.Scanner;

public class BOJ18428_감시피하기 {

	static int n;
	static String[][] map, wall;
	static boolean[][] check;
	static boolean result = false;
	static int[] nx = { 1, -1, 0, 0 };
	static int[] ny = { 0, 0, 1, -1 };
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		map = new String[n][n];
		wall = new String[n][n];
		check = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				String str = sc.next();
				map[i][j] = str;
			}
		}

		per(0);

		if (result) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static void per(int cnt) {
		if (cnt == 3) {
			confirm();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				String str = map[i][j];
				
				if (str.equals("X") && !check[i][j]) {		
					check[i][j] = true;
					map[i][j] = "O";
					per(cnt + 1);
					if (result)	return;
					check[i][j] = false;
					map[i][j] = "X";
				}
			}
		}
	}
	
	private static void confirm() {
		boolean confirmCheck = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				String teacher = map[i][j];

				if (teacher.equals("T")) {
					for (int k = 0; k < 4; k++) {
						confirmCheck = dfs(i + nx[k], j + ny[k], nx[k], ny[k]);
						if (confirmCheck)
							return;
					}
				}
			}
		}
		result = true;
	}

	private static boolean dfs(int i, int j, int x, int y) {

		if (i >= 0 && j >= 0 && i < n && j < n) {
			String str = map[i][j];
			if (str.equals("O")) {
				return false;
			} else if (str.equals("S")) {
				return true;
			} else {
				return dfs(i + x, j + y, x, y);
			}
		}
		return false;
	}
}
