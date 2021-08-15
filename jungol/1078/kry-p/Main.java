import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final int[] DX = { 1, -1, 0, 0 };
    private static final int[] DY = { 0, 0, 1, -1 };
    private static int[][] map;
    private static int row, col, max;
    private static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        col = Integer.parseInt(input[0]);
        row = Integer.parseInt(input[1]);

        map = new int[row][col];
        isVisited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            input = reader.readLine().split("");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        input = reader.readLine().split(" ");
        int initialY = Integer.parseInt(input[0]) - 1;
        int initialX = Integer.parseInt(input[1]) - 1;

        map[initialX][initialY] = 3;
        bfs(initialX, initialY);

        System.out.println(max);

        int survived = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 1)
                    survived += 1;
            }
        }
        System.out.println(survived);
    }

    public static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        isVisited[x][y] = true;
        max = Math.max(map[x][y], max);

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = p.getX() + DX[i];
                int nextY = p.getY() + DY[i];

                if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col)
                    continue;
                if (isVisited[nextX][nextY])
                    continue;
                if (map[nextX][nextY] == 1) {
                    map[nextX][nextY] = map[p.getX()][p.getY()] + 1;
                    isVisited[nextX][nextY] = true;
                    max = Math.max(max, map[nextX][nextY]);
                    queue.add(new Point(nextX, nextY));
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