import java.util.*;
import java.io.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    private final static int[] HORSE_DX = { -2, -2, -1, -1, 1, 1, 2, 2 };
    private final static int[] HORSE_DY = { -1, 1, -2, 2, 2, -2, 1, -1 };
    
    private static int k, w, h, min;
    private static int[][] map;
    private static boolean[][][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(reader.readLine());
        String[] wh = reader.readLine().split(" ");
        w = Integer.parseInt(wh[0]);
        h = Integer.parseInt(wh[1]);

        min = Integer.MAX_VALUE;
        map = new int[h][w];
        isVisited = new boolean[h][w][k + 1];
        for (int i = 0; i < h; i++)
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        bfs(0, 0);
        if (min == Integer.MAX_VALUE) System.out.print("-1");
        else System.out.print(min);
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, k, 0));
        isVisited[x][y][k] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.x == h - 1 && current.y == w - 1) {
                min = current.count;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + DX[i];
                int nextY = current.y + DY[i];
                if (nextX < 0 || nextY < 0 || nextX >= h || nextY >= w) continue;
                if (isVisited[nextX][nextY][current.k]) continue;
                if (map[nextX][nextY] == 1) continue;

                queue.add(new Node(nextX, nextY, current.k, current.count + 1));
                isVisited[nextX][nextY][current.k] = true;
            }

            if (current.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int nextX = current.x + HORSE_DX[i];
                    int nextY = current.y + HORSE_DY[i];

                    if (nextX < 0 || nextY < 0 || nextX >= h || nextY >= w) continue;
                    if (isVisited[nextX][nextY][current.k - 1]) continue;
                    if (map[nextX][nextY] == 1) continue;

                    queue.add(new Node(nextX, nextY, current.k - 1, current.count + 1));
                    isVisited[nextX][nextY][current.k - 1] = true;
                }
            }
        }
    }
}

class Node {
    int x, y, k, count;

    public Node(int x, int y, int k, int count) {
        this.x = x; 
        this.y = y;
        this.k = k; // 나이트처럼 이동할 수 있는 잔여 횟수
        this.count = count; // 이동 횟수
    }
}