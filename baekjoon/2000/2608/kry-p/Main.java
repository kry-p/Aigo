import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        String s1 = reader.readLine();
        String s2 = reader.readLine();
    
        int num1 = romanToArabic(s1);
        int num2 = romanToArabic(s2);
        int sum = num1 + num2;

        builder.append(Integer.toString(sum) + "\n");
        builder.append(arabicToRoman(sum));
        System.out.print(builder.toString());
    }

    private static int romanToArabic(String numberString) {
        ArrayList<Integer> list = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < numberString.length(); i++) {
            switch (numberString.charAt(i)) {
                case 'I':
                    list.add(1);
                    break;
                case 'V':
                    list.add(5);
                    break;
                case 'X':
                    list.add(10);
                    break;
                case 'L':
                    list.add(50);
                    break;
                case 'C':
                    list.add(100);
                    break;
                case 'D':
                    list.add(500);
                    break;
                default:
                    list.add(1000);
            }
        }
        int currentIndex = 0;
        while (currentIndex < list.size()) {
            if (currentIndex == list.size() - 1) result += list.get(currentIndex);
            else {
                if (list.get(currentIndex) < list.get(currentIndex + 1)) {
                    result += list.get(currentIndex + 1) - list.get(currentIndex);
                    currentIndex = currentIndex + 2;
                    continue;
                } else {
                    result += list.get(currentIndex);
                }
            }
            currentIndex += 1;
        }
        return result;
    }

    private static String arabicToRoman(int number) {
        StringBuilder builder = new StringBuilder();
        String[] to = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] from = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int calc = number;

        for (int i = 0; i < from.length; i++)
            while (calc >= from[i]) {
                builder.append(to[i]);
                calc -= from[i];
            }

        return builder.toString();
    }
}