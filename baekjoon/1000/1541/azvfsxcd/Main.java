import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		String[] arr = s.split("-");
		int add = 0;
		for(int i = 0; i<arr.length; i++) {
			int sum = 0;
			//arr[i].split("+");	//+, *, ^ 는 split 쓸때 앞에 \\ 붙여서 써야함
			String[] sarr = arr[i].split("\\+");			
			for(int j = 0 ; j < sarr.length; j++) {
				sum += Integer.parseInt(sarr[j]);
			}
			if(i!=0) {
				add -= sum;
			} else {
				add +=sum;
			}
		}
		System.out.println(add);
		
//		char[] c = s.toCharArray();
//		char[] arr = new char[100];
//		boolean[] bra = new boolean[100];
//		boolean flag = false;
//		for(int i = 0; i < c.length; i++) {
//			if(c[i]=='-' && !flag) {
//				flag = true;
//				bra[i]=true;
//			} else if (c[i]=='-' && flag) {
//				flag = false;
//				bra[i] = true;
//			}
//			if(i==c.length-1 && flag) {
//				flag = false;
//				bra[i+1] = true;
//			}
//		}
//		int cnt = 0;
//		for(int i = 0; i < c.length; i++) {
//			if(!bra[i]) {
//				arr[cnt++] = c[i];
//			} else if(bra[i] && !flag){
//				arr[cnt++] = '(';
//				arr[cnt++] = c[i];
//				flag = true;
//			} else {
//				arr[cnt++] = ')';
//				arr[cnt++] = c[i];
//				flag = false;
//			}
//			if(i==c.length-1 &&flag) {
//				arr[cnt++] = ')';
//				flag = false;
//			}
//		}
//		int sum = 0, a = 0;
//		boolean flag2 = false;
//		for(int i = 0; i < arr.length; i++) {
//			
//		}
//		
//		System.out.println(sum);
		
	}
}
