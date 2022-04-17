package test09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class T216_BOJ13417_카드문자열 {
	static String res;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int i, t, n;
		t = Integer.parseInt(in.readLine());
		String card;
		while(t-->0){
			n = Integer.parseInt(in.readLine());
			card = in.readLine().replaceAll(" ", "");
			res = card.substring(0, 1);
			for(i=1;i<n;i++) positioning(card.charAt(i));
			out.write(res);
			out.newLine();
		}
		out.close();
		in.close();
	}
	private static void positioning(char card){
		if(card <= res.charAt(0)) res = card+res;
		else res+=card;
	}
}
