package Arithmetic;
import java.io.*;

public class Q2420_SafariWorld_B5 {
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		
		  BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		  BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
		  
		  String nums[] = br.readLine().split(" ");
		  
		  long n = Long.parseLong(nums[0]);
		  long m = Long.parseLong(nums[1]);
		  //결과 값의 최대치가 4,000,000,000이기 때문에 int의 범위를 초과하므로 long으로 입력한다.
		  
		  bw.write(String.valueOf(Math.abs(n - m)));
		  //Math.abs() 메소드는 인자의 절대값을 반환해준다.
		  
		  bw.flush(); 
		  bw.close();
		
	}

}