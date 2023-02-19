import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0];
        int k = nk[1];
        int[] heights = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] subs = new int[n - 1];
        int result = 0;

        // 키의 차이 배열을 만듦
        for (int i = 0; i < n - 1; i++)
            subs[i] = heights[i + 1] - heights[i];

        Arrays.sort(subs);

        for (int i = 0; i < n - k; i++)
            result += subs[i];

        System.out.println(result);
    }
}