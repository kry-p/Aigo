import java.io.*;
import java.util.*;

public class Main {
    private static Map<Character, Integer> map;
    private static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        System.out.print(isValid(str) ? '1' : '0');
    }

    private static void initializeMap() {
        map = new HashMap<>();
        map.put('w', 0);
        map.put('o', 1);
        map.put('l', 2);
        map.put('f', 3);
    }
    
    private static boolean isValidPart() {
        int wCount = count[0];
        if (wCount == count[1] && wCount == count[2] && wCount == count[3]) return true;
        return false;
    }

    private static boolean isValid(String str) {
        if (str.length() < 4) return false;
        boolean flag = true;
        count = new int[4];
        initializeMap();
        count[map.get(str.charAt(0))] = 1; 

        for (int i = 1; i < str.length(); i++) {
            int previous = map.get(str.charAt(i - 1));
            int current = map.get(str.charAt(i));
            int difference = current - previous;

            // f -> w
            if (difference == -3) {
                if (isValidPart()) {
                    count = new int[4];
                    count[0] = 1;
                } else {
                    flag = false;
                    break;
                }
            } else {
                // w -> o, o -> l, l -> f와 같은 문자 반복만 허용
                if (difference == 1 || difference == 0) count[current] += 1;
                else {
                    flag = false;
                    break;
                }
            }
        }
        if (!isValidPart()) flag = false; // 마지막 wolf 문자열에 대해 검증
        return flag;
    }
}
