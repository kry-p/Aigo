package test09;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T215_BOJ9375_패션왕신해빈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		
		for (int i = 0; i < count; i++) {
			Map<String, Integer> set = new HashMap<>();
			int n = sc.nextInt();
			for (int j = 0; j < n; j++) {
				String str = sc.next();
				String key = sc.next();
				if (set.containsKey(key)) {
					int add = set.get(key) + 1;
					set.put(key, add);
				} else {
					set.put(key, 1);
				}
			}
			
			int answer=1;
			for(int value: set.values()) {
				answer*=value+1;
			}
			System.out.println(answer-1);
		}
	}

}
