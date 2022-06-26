import java.io.*;
import java.util.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    private static int n, l, r;
    private static int[][] map, group;
    private static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        l = Integer.parseInt(input[1]);
        r = Integer.parseInt(input[2]);

        map = new int[n][n];
        group = new int[n][n];

        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int attempt = 0;
        while (true) {
            isVisited = new boolean[n][n];
            int groupCount = 0;

            for (int i = 0; i < n; i++) 
                for (int j = 0; j < n; j++) 
                    if (!isVisited[i][j]) {
                        createGroup(groupCount, i, j);
                        groupCount += 1;
                    }

            // 연합이 형성되지 않음
            if (groupCount >= (n * n))
                break;
            attempt += 1;

            isVisited = new boolean[n][n];
            for (int i = 0; i < n; i++) 
                for (int j = 0; j < n; j++) 
                    if (!isVisited[i][j]) 
                        findGroupAndReplace(i, j); 
        }

        System.out.println(attempt);
    }

    private static void createGroup(int groupNumber, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        isVisited[x][y] = true;
        group[x][y] = groupNumber;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + DX[i];
                int nextY = current.y + DY[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
                    continue;
                if (isVisited[nextX][nextY])
                    continue;
                int sub = Math.abs(map[current.x][current.y] - map[nextX][nextY]);
                if (sub >= l  && sub <= r) {
                    queue.add(new Point(nextX, nextY));
                    group[nextX][nextY] = groupNumber;
                    isVisited[nextX][nextY] = true;
                }
            }
        }
    }

    private static void findGroupAndReplace(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        Queue<Point> replacement = new LinkedList<>();
        queue.add(new Point(x, y));
        replacement.add(new Point(x, y));
        isVisited[x][y] = true;
        int groupNumber = group[x][y];
        int groupSum = map[x][y];

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + DX[i];
                int nextY = current.y + DY[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
                    continue;
                if (isVisited[nextX][nextY])
                    continue;
                if (group[nextX][nextY] == groupNumber) {
                    isVisited[nextX][nextY] = true;
                    groupSum += map[nextX][nextY];
                    replacement.add(new Point(nextX, nextY));
                    queue.add(new Point(nextX, nextY));
                }
            }
        }

        int split = groupSum / replacement.size();
        while (!replacement.isEmpty()) {
            Point current = replacement.poll();
            map[current.x][current.y] = split;
        }
    }
}

class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x; this.y = y;
    }
}