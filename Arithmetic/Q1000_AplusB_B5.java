package Arithmetic;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Q1000_AplusB_B5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" "); // string 클래스의 메소드 split()은 "" 안의 string을
												// 기준으로 삼아서 string을 배열로 분할해준다. 해당 코드에서는
												//공백을 기준으로 분할했다. 
		int in[] = new int[str.length];
		int res = 0;
		
		for( int i = 0 ; i < str.length ; i++ ) {
			in[i] = Integer.parseInt(str[i]);
			res = res + in[i];
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		bw.write(res + "\n");
		
		bw.flush();
		bw.close();

	}

}
// 해당 코드는 더할 수의 개수에 제약이 없다는 장점이 있다. 

//	메모리: 15852KB	시간: 152ms