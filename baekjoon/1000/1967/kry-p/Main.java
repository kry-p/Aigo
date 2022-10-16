import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Node>> graph;
    private static boolean[] isVisited;
    private static int end, maxDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(reader.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= nodes; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < nodes - 1; i++) {
            int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(input[0]).add(new Node(input[1], input[2]));
            graph.get(input[1]).add(new Node(input[0], input[2]));
        }

        // 시작점으로부터 가장 먼 노드를 구함
        isVisited = new boolean[nodes + 1];
        maxDistance = Integer.MIN_VALUE;
        dfs(1, 0);

        // 해당 노드로부터의 최대 거리를 구함
        isVisited = new boolean[nodes + 1];
        maxDistance = Integer.MIN_VALUE;
        dfs(end, 0);

        // 구한 최대 거리가 트리의 지름임
        System.out.print(maxDistance);
    }

    private static void dfs(int current, int cost) {
        if (maxDistance < cost) {
            end = current;
            maxDistance = cost;
        }
        isVisited[current] = true;

        for (Node n : graph.get(current)) {
            if (isVisited[n.getVertex()]) continue;
            dfs(n.getVertex(), cost + n.getCost());
        }
    }
}

class Node implements Comparable<Node> {
    private int n, cost;

    public Node(int n, int cost) {
        this.n = n;
        this.cost = cost;
    }

    public int getVertex() {
        return n;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}