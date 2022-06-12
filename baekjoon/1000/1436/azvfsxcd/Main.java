package Algo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1436_영화감독숌 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		int count = 0;

		for (int i = 0; true; i++) {
			String str = Integer.toString(i);
			if (str.contains("666"))
				count++;

			if (count == num) {
				num = i;
				break;
			}

		}
		System.out.println(num);

	}

}
