package test09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class T210_BOJ1181_단어정렬 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 중복 제거
		HashSet<String> hashSet = new HashSet<>();
		// 입력
		for(int i = 0 ; i < N; i++)
		{
			hashSet.add(br.readLine());
		}
		ArrayList<String> data = new ArrayList<>(hashSet);
		
        Collections.sort(data, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length())
                    return o1.length() - o2.length();
                else
                    return o1.compareTo(o2);
            }
        });
        for (String string : data) {
            System.out.println(string);
        }

	}
}
