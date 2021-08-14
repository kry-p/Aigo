import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        
        while(testcase-->0) {
            String str=br.readLine();
            boolean isVps=true;
            Stack<Character> marks=new Stack<Character>();
            
            for(int i=0;i<str.length();i++) {
                char temp=str.charAt(i);
                if(temp=='(') {
                    marks.push('(');
                } else {
                    if(marks.isEmpty()) {
                        isVps=false;
                        break;
                    }
                    marks.pop();
                }
            }
            if (isVps && marks.isEmpty()) {
                sb.append("YES \n");
            } else {
                sb.append("NO \n");
            }
        }
        System.out.println(sb);
    }
}
