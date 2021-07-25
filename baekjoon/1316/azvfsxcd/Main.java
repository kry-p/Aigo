import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int cnt = 0;
		int num = sc.nextInt();
		

		for (int i = 0; i < num; i++) {
			boolean test=true;
			boolean[] check = new boolean[26];
			int prev = 0;
			String str = sc.next();
			
			for (int j = 0; j < str.length(); j++) {
				int now = str.charAt(j);

				if (prev != now) {
					if (check[now - 'a'] == false) {
						check[now - 'a'] = true;
						prev = now;
					} else {
						test = false;
						break;
					}
				} else {
					continue;
				}
			}
			
			if(test==true) {
				cnt++;
			}
			
		}

		System.out.println(cnt);
	}
}

	