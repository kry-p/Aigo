import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (sc.hasNext()) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			String s1 = st.nextToken();
//			String s2 = st.nextToken();
			String[] str = sc.nextLine().split(" ");
			String[] word1 = str[0].split("");
			String[] word2 = str[1].split("");
//			char[] c1 = s1.toCharArray();
//			char[] c2 = s2.toCharArray();
			int a = 0;
//			String answer = "Yes";
			boolean flug = false;
			for (int i = 0; i < word1.length; i++) {
				flug = false;
				for (int j = a; j < word2.length; j++) {
					if (word1[i].equals(word2[j])) {
//						System.out.println(c1[i] + " " + c2[j]);
						a = 1 + j;
						flug = true;
						break;
					}
				}
				if(!flug) {
					break;
				}
			}

			System.out.println(flug ? "Yes" : "No");
		}
	}
}
