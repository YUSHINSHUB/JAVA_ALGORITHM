package Arithmetic;

import java.io.*;

public class Q10156_Cookie_B4 {
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		
		  BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		  BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
		  
		  String nums[] = br.readLine().split(" ");
		  int    num[] = new int[3];
		  
		  int money = 0;
		  
		  for( int i = 0 ; i < 3 ; i++ ) {
			  num[i] = Integer.parseInt(nums[i]);
		  }
		  
		  money = (num[0] * num[1]) - num[2];
		  
		  if( money >= 0 ) {
		  bw.write(String.valueOf(money));
		  }else {
			  bw.write(String.valueOf(0));
		  }
		  
		  bw.flush(); 
		  bw.close();
		
	}

}
