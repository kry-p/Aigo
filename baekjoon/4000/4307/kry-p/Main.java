import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = reader.readLine().split(" ");
            int l = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int max = 0;
            int min = 0;

            for (int j = 0; j < n; j++) {
                int pos = Integer.parseInt(reader.readLine());

                // 시간의 최솟값은 각 개미가 양쪽 끝으로 걸어가는 경우 중 최소임
                // 또, 최솟값은 각 개미가 양쪽 끝으로 걸어가는 경우 중 최대

                // 두 개미가 충돌하여 방향을 바꾸어 걸어가더라도 진행 방향만 서로 반대가 될 뿐이므로 고려할 필요가 없음
                min = Math.max(Math.min(pos, l - pos), min);
                max = Math.max(Math.max(pos, l - pos), max);
            }
            builder.append(min + " " + max + "\n");
        }

        System.out.print(builder.toString());
    }
}
