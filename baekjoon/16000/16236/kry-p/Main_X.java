import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final int[] DX = { 1, -1, 0, 0 };
    private static final int[] DY = { 0, 0, 1, -1 };
    private static int[][] map;
    private static int[][] attempt;
    private static int n, shark, time;
    private static boolean[][] isVisited;
    private static Queue<Point> next;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());

        map = new int[n + 1][n + 1];
        attempt = new int[n + 1][n + 1];
        isVisited = new boolean[n + 1][n + 1];
        next = new LinkedList<>();
        shark = 2;
        time = 0;
    }

    private static void checkSmallestFish() {
        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            min = Math.min(min, map[temp.getX()][temp.getY()]);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]==min)
            }
        }
    }

    private static boolean checkFish() {
        boolean result = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0 && map[i][j] <= shark)
                    result = true;
            }
        }
        return result;
    }

    public static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int[] next = { current - 1, current + 1, current * 2 };

            for (int i = 0; i < 4; i++) {
                int nextX = x + DX[i];
                int nextY = y + DY[i];

                // 범위를 벗어났을 때
                if (nextX < 1 || nextX >= n || nextY < 1 || nextY >= n)
                    continue;

                // 지나갈 수 없는 칸
                if (map[nextX][nextY] > shark)
                    continue;

                if (map[nextX][nextY] != 0 && map[nextX][nextY] != 9) {
                    Main.next.add(new Point(nextX, nextY));
                }

                if (!isVisited[nextX][nextY] || attempt[nextX][nextY] == attempt[x][y] + 1) {
                    queue.add(new Point(nextX, nextY));
                    attempt[nextX][nextY] = attempt[x][y] + 1;
                    isVisited[x][y] = true;
                }
            }
        }
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
