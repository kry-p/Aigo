import java.util.Scanner;

public class Main {
    private static int[] result;
    private static boolean[] isVisited;
    private static int count;
    private static StringBuilder builder;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        count = scanner.nextInt();
        int type = scanner.nextInt();
        scanner.close();

        result = new int[count + 1];
        isVisited = new boolean[6 + 1];
        result[0] = 1;
        builder = new StringBuilder();

        switch (type) {
            case 1:
                dfs1(1);
                break;
            case 2:
                dfs2(1);
                break;
            case 3:
                dfs3(1);
                break;
            default:
                break;
        }

        System.out.println(builder.toString());
    }

    private static void dfs1(int depth) {
        if (depth > count) {
            for (int i = 1; i <= count; i++) {
                if (i == count)
                    builder.append(result[i]);
                else
                    builder.append(result[i] + " ");
            }
            builder.append("\n");
            return;
        }

        for (int i = 1; i <= 6; i++) {
            result[depth] = i;
            dfs1(depth + 1);
        }
    }

    private static void dfs2(int depth) {
        if (depth > count) {
            for (int i = 1; i <= count; i++) {
                if (i == count)
                    builder.append(result[i]);
                else
                    builder.append(result[i] + " ");
            }
            builder.append("\n");
            return;
        }

        for (int i = result[depth - 1]; i <= 6; i++) {
            result[depth] = i;
            dfs2(depth + 1);
        }
    }

    private static void dfs3(int depth) {
        if (depth > count) {
            for (int i = 1; i <= count; i++) {
                if (i == count)
                    builder.append(result[i]);
                else
                    builder.append(result[i] + " ");
            }
            builder.append("\n");
            return;
        }

        for (int i = 1; i <= 6; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                result[depth] = i;
                dfs3(depth + 1);

                isVisited[i] = false;
            }
        }
        return;
    }
}