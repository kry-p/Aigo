import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, cnt = 0;
	static int[][] map;
	static Shark shark;
	static int[] fish; // 상어가 먹을 물고기
	static int moveCnt; // 상어가 물고기를 먹기 위해 움직인 총 시간

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class Shark {
		int x, y, size = 2, eat;

		Shark(int x, int y) {
			this.x = x;
			this.y = y;
		}

		void eat() {
			map[x][y] = 0; // 물고기를 먹기 전의 상어 좌표를 0 으로
			x = fish[0];
			y = fish[1];
			if (size == ++eat) {
				size++;
				eat = 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					shark = new Shark(i, j);
				}

			}
		}
		// 상어가 물고기를 먹을때 까지 계속 호출한다.
		while (bfs());
		System.out.println(moveCnt);
	}

	private static boolean bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(shark.x, shark.y));
		boolean[][] visited = new boolean[N][N];
		visited[shark.x][shark.y] = true;
		
		cnt = 0;		// 이걸 깜빡함
		while (!queue.isEmpty()) {
			int size = queue.size(); // 움직이는 시간이 같은 얘들의 크기
			cnt++;

			for (int i = 0; i < size; i++) {
				Point p = queue.poll();

				for (int d = 0; d < 4; d++) {
					int nx = p.x + dx[d];
					int ny = p.y + dy[d];

					// 범위 밖에 있다면 건너뛰기
					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;
					// 기준 방문했던 위치
					if (visited[nx][ny])
						continue;
					// 물고기의 크기가 상어의 크기보다 크다면 이동 불가능
					if (map[nx][ny] > shark.size)
						continue;

					visited[nx][ny] = true;

					// 이동
					if (map[nx][ny] == 0 || map[nx][ny] == shark.size) { // 물고기가 상어랑 크기가 같을 경우는 먹지는 못하고 이동만 가능
						queue.add(new Point(nx, ny));
					}
					// 먹방
					else {
						if (fish == null) {
							fish = new int[] { nx, ny };
						} else {
							if (fish[0] > nx || (fish[0] == nx && fish[1] > ny)) { //여러마리일 경우 왼쪽의 물고기 선택 x축이 같다면 밑 먼저
								fish[0] = nx;
								fish[1] = ny;
							}
						}
					}
				}
			}

			if (fish != null) { // 먹을 물고기가 있는 경우
				shark.eat();
				moveCnt += cnt;
				fish = null;
				return true;

			}

		}
		return false;
	}

}
