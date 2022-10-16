import java.io.*;

public class Main {
    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        isPrime = new boolean[1000000 + 1];

        for (int i = 2; i <= 1000000; i++) 
            isPrime[i] = checkPrimeNumber(i);

        while (true) {
            int input = Integer.parseInt(reader.readLine());
            if (input == 0 ) break;
            builder.append(verify(input));
        }

        System.out.print(builder.toString());
    }

    private static boolean checkPrimeNumber(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) 
            if (n % i == 0) return false;
        return true;
    }

    private static String verify(int input) {
        for (int i = 2; i <= 1000000; i++)
            if (isPrime[i] && isPrime[input - i])
                return input + " = " + i + " + " + (input - i) + "\n";
        return "Goldbach's conjecture is wrong.\n";
    }
}