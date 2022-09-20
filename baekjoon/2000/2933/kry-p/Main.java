import java.util.*;
import java.io.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    private static ArrayList<ArrayList<Point>> seperatedClusters; 
    private static boolean[][] map, isVisited;
    private static int sizeX, sizeY;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sizeX = size[0];
        sizeY = size[1];
        map = new boolean[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            String[] input = reader.readLine().split("");

            for (int j = 0; j < input.length; j++)
                map[i][j] = input[j].equals("x");
        }
        int throwingAttempt = Integer.parseInt(reader.readLine());
        int[] throwingArray = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < throwingAttempt; i++) {
            throwStick(i % 2 == 0 ? "left" : "right", throwingArray[i]);
            findClusters();
            for (int j = 0; j < seperatedClusters.size(); j++) 
                fallClusters(seperatedClusters.get(j));
        }
        printMinerals();
    }

    // 막대기를 던짐
    private static void throwStick(String from, int height) {
        if (from.equals("left")) {
            for (int i = 0; i < sizeY; i++) {
                if (map[sizeX - height][i]) {
                    map[sizeX - height][i] = false;
                    break;
                }
            }
        } else {
            for (int i = sizeY - 1; i >= 0; i--) {
                if (map[sizeX - height][i]) {
                    map[sizeX - height][i] = false;
                    break;
                }
            }
        }
    }

    // 클러스터를 찾음
    private static void findClusters() {
        isVisited = new boolean[sizeX][sizeY];
        seperatedClusters = new ArrayList<>();

        // 바닥에 붙어 떨어지지 않는 클러스터부터 체크
        for (int i = 0; i < sizeY; i++) 
            if (map[sizeX - 1][i]) 
                createCluster(sizeX - 1, i, false);

        // 아직 미네랄이 남아 있는 칸 체크 (공중에 떠 있음, 떨어져야 함)
        for (int i = 0; i < map.length; i++) 
            for (int j = 0; j < map[0].length; j++) 
                if (map[i][j] && !isVisited[i][j]) createCluster(i, j, true);
    }
     
    // 클러스터 처리, 클러스터가 공중에 떠 있으면 집합으로 만듦 
    private static void createCluster(int x, int y, boolean isSeperated) {
        ArrayList<Point> clusterItems = new ArrayList<>();
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        isVisited[x][y] = true;

        if (isSeperated) {
            clusterItems.add(new Point(x, y));
            map[x][y] = false;
        }

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + DX[i];
                int nextY = current.y + DY[i];

                if (nextX < 0 || nextX >= sizeX || nextY < 0 || nextY >= sizeY)
                    continue;
                if (isVisited[nextX][nextY])
                    continue;
                if (!map[nextX][nextY]) 
                    continue;

                isVisited[nextX][nextY] = true;
                queue.add(new Point(nextX, nextY));
                if (isSeperated) {
                    clusterItems.add(new Point(nextX, nextY));
                    map[nextX][nextY] = false;
                }
            }
        }
        if (isSeperated) seperatedClusters.add(clusterItems);
    }
    
    // 클러스터를 떨어트림
    private static void fallClusters(ArrayList<Point> cluster) {
        boolean isFalling = true;
        while (isFalling) {
            for (Point p : cluster) {
                int nextX = p.x + 1;
                int nextY = p.y;

                if (nextX >= sizeX || map[nextX][nextY] ) {
                    isFalling = false;
                    break;
                }
            }
            if (isFalling)
                for (Point p : cluster) 
                    p.x += 1;
        }

        // 다시 그림
        for (Point p : cluster)
            map[p.x][p.y] = true;
    }

    // 미네랄 모양을 출력
    private static void printMinerals() {
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) 
                builder.append(map[i][j] ? "x" : ".");
            builder.append("\n");
        }

        System.out.println(builder.toString());
    }
}

class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
