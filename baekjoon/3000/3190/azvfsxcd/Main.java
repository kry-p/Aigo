package algoStudy01;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3190_뱀 {

	static BufferedReader br;
	static StringTokenizer st;
	static int N, K, L;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int answer, d;
	

	static class Dir {
		int t;
		String s;

		public Dir(int t, String s) {
			this.t = t;
			this.s = s;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		map[1][1] = 2;

		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}

		L = Integer.parseInt(br.readLine());
		Queue<Dir> q = new LinkedList<>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			q.add(new Dir(Integer.parseInt(st.nextToken()), st.nextToken()));
		}

		Deque<Point> snake = new LinkedList<>();
		snake.addLast(new Point(1, 1));

		while (true) {

			answer++;

			Point p = snake.peekLast(); // 머리 위치
			int nr = p.x + dir[d % 4][0];
			int nc = p.y + dir[d % 4][1];

			if (1 <= nr && nr <= N && 1 <= nc && nc <= N) {
				if (map[nr][nc] == 2) {
					break; // 자기한테 닿아서 끝
				}

				if (map[nr][nc] == 0) { // 사과가 없으면 꼬리 없애고 있으면 그대로
					Point tail = snake.pollFirst();
					map[tail.x][tail.y] = 0;
				}

				snake.offerLast(new Point(nr, nc));
				map[nr][nc] = 2;
			} else
				break; // 아니면 벽에 닿아서 끝

			// 방향전환 할 게 남아있고, 그 시간이 현재 시간과 같다면
			if (!q.isEmpty() && q.peek().t == answer) {
				Dir temp = q.poll();
				if (temp.s.equals("L")) {
					d += 3; // 왼쪽
				} else {
					d += 1; // 오른쪽
				}
			}
		}

		System.out.println(answer);

	}

}