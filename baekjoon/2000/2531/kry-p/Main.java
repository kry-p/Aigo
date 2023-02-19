import java.util.*;
import java.io.*;

public class Main {
    private static int n, d, k, c;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] ndkc = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Integer.MIN_VALUE;
        n = ndkc[0];
        d = ndkc[1];
        k = ndkc[2];
        c = ndkc[3];
        int[] sushis = new int[n];
        for (int i = 0; i < n; i++)
            sushis[i] = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            boolean[] isVisited = new boolean[d + 1];
            int count = 0;
            for (int j = 0; j < k; j++) isVisited[sushis[(i + j) % n]] = true;
            isVisited[c] = true;
            for (int j = 0; j < isVisited.length; j++) if (isVisited[j]) count += 1;
            max = Math.max(max, count);
        }        
        System.out.println(max);
    }
}