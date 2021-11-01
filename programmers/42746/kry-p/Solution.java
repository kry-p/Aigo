import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numArr = new String[numbers.length];
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < numbers.length; i++)
            numArr[i] = String.valueOf(numbers[i]);

        Arrays.sort(numArr, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return ((o2 + o1).compareTo(o1 + o2));
            }
        });

        for (String s : numArr)
            builder.append(s);

        answer = builder.toString();

        if (numArr[0].equals("0"))
            return "0";
        else
            return answer;
    }
}