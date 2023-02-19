import java.util.*;
import java.io.*;

public class Main {
    private static boolean[] isVisited;
    private static ArrayList<Integer>[] nodes;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = reader.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        nodes = new ArrayList[n];
        isVisited = new boolean[n];

        for (int i = 0; i < n; i++) 
            nodes[i] = new ArrayList<>();       
        
        for (int i = 0; i < m; i++) {
            String[] edge = reader.readLine().split(" ");
            nodes[Integer.parseInt(edge[0]) - 1].add(Integer.parseInt(edge[1]) - 1);
        }

        int s = Integer.parseInt(reader.readLine());
        int[] fans = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        for (int i : fans) 
            isVisited[i - 1] = true;

        System.out.println(bfs() ? "yes" : "Yes");
    }

    private static boolean bfs() {
        if (isVisited[0]) return false; // 시작 위치에 팬클럽 곰곰이가 있으면 여행 불가

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        isVisited[0] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            if (nodes[current].size() == 0) return true; // 탐색이 성공적으로 종료될 수 있으면 true 반환

            for (int i = 0; i < nodes[current].size(); i++) {
                int next = nodes[current].get(i);
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    queue.add(next);
                }
            }
        }

        return false;
    }
}