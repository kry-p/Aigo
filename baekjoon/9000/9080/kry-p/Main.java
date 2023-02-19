import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int fee = 0;
            String[] input = reader.readLine().split(" ");
            String[] startTime = input[0].split(":");

            int playTime = Integer.parseInt(input[1]);
            int hour = (Integer.parseInt(startTime[0]) + 2) % 24; // 조건 분기를 줄이기 위해 2시간씩 뒤로 밀기
            int minute = Integer.parseInt(startTime[1]);

            while (playTime > 0) {
                // 야간 요금이 적용되는 조건
                // 5시간 이상 플레이해야 야간 요금이 이득임
                if (hour <= 4 && playTime > 300) {
                    playTime -= (600 - (hour * 60 + minute));
                    hour = 10;
                    minute = 0;
                    fee += 5000;
                } else {
                    // 시간당 요금 적용
                    hour = (hour + 1) % 24;
                    playTime -= 60;
                    fee += 1000;
                }
            }
            builder.append(Integer.toString(fee) + "\n");
        }
        System.out.print(builder.toString());
    }

}
