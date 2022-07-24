import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	  // N을 입력받는다.
	  int N = Integer.parseInt(br.readLine());

	  List<String> list = new ArrayList<>();

	  for(int i = 0; i < 1000000; i++) {
		  if(String.valueOf(i).length() == 1){
			  list.add(String.valueOf(i));
		  }else{
			  String temp = String.valueOf(i);
			  for(int j = 0; j < temp.length(); j++) {
				  if(j != 0 && temp.charAt(j-1) > temp.charAt(j)){
					  list.add(temp);
				  }
			  }
		  }
	  }
	  
	  System.out.println(list.get(N));
 } 
}
