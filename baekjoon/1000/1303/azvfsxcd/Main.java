import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
    static String[][] arr;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int whiteCount = 0;
    static int blackCount = 0;

    static class Point {
        int x;
        int y;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((System.in)));
        String s = bufferedReader.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new String[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.substring(j, j + 1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false) {
                    if (arr[i][j].equals("B")) {
                        int num = bfs("B", i, j);
                        blackCount += Math.pow(num, 2);
                    } else if (arr[i][j].equals("W")) {
                        int num = bfs("W", i, j);
                        whiteCount += Math.pow(num, 2);
                    }
                }
            }
        }
        System.out.println(whiteCount + " " + blackCount);
    }

    public static int bfs(String color, int y, int x) {
        int count = 1;
        Queue<Point> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.offer(new Point(y, x));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (visited[ny][nx] == false && color.equals(arr[ny][nx])) {
                        queue.offer(new Point(ny, nx));
                        visited[ny][nx] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
