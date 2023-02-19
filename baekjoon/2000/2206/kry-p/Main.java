import java.io.*;
import java.util.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    private static int n, m;
    private static int[][] map;
    private static int[][][] minimum;
    private static boolean[][][] isVisited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        map = new int[n][m];
        isVisited = new boolean[n][m][2]; // 좌표와 벽을 부순 여부
        minimum = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                minimum[i][j][0] = Integer.MAX_VALUE;
                minimum[i][j][1] = Integer.MAX_VALUE;
            }
        }
        bfs(0, 0);
        int min = Math.min(minimum[n - 1][m - 1][0], minimum[n - 1][m - 1][1]);
        System.out.println(min == Integer.MAX_VALUE ? "-1" : min);
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0));
        minimum[x][y][0] = 1;
        minimum[x][y][1] = 1;
        isVisited[x][y][0] = true;
        isVisited[x][y][1] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + DX[i];
                int nextY = current.y + DY[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if (isVisited[nextX][nextY][current.broken]) continue;
                if (map[nextX][nextY] == 1) {
                    if (current.broken == 0) {
                        minimum[nextX][nextY][1] = Math.min(minimum[nextX][nextY][1], minimum[current.x][current.y][0] + 1);
                        isVisited[nextX][nextY][1] = true;
                        queue.add(new Point(nextX, nextY, 1));
                    }
                } else {
                    minimum[nextX][nextY][current.broken] = Math.min(minimum[nextX][nextY][current.broken], minimum[current.x][current.y][current.broken] + 1);
                    isVisited[nextX][nextY][current.broken] = true;
                    queue.add(new Point(nextX, nextY, current.broken));
                }
            }
        }
    }
}

class Point {
    public int x, y, broken;
    public Point(int x, int y, int broken) {
        this.x = x;
        this.y = y;
        this.broken = broken;
    }
}