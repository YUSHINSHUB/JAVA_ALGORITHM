package Arithmetic;

import java.io.*;

public class Q5543_Sangdonald_B4 {
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		
		  BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		  BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
		  
		  int bmin = 2001;
		  int dmin = 2001;
		  //단일 메뉴의 가격은 2000원이 절대 넘지 않는다는 조건이 있기 때문에
		  // for반복에서 무조건 버거 또는 음료의 첫번쨰 가격이 min에 대입되기 위해 2001로 설정해준다.
		  
		  int smin;
		  
		  int burger[] = new int[3];
		  int drink[]  = new int[2];
		  
		  for( int i = 0 ; i < 3 ; i++ ) {
			  burger[i] = Integer.parseInt(br.readLine());
			  bmin = Math.min(bmin, burger[i]);
			  // Math.min( int, int ) 메소드는 두 정수중 작은 값을 반환한다.
			  //반대로 Math.max는 큰 값을 반환한다.
		  }
		  
		  for( int i = 0 ; i < 2 ; i++ ) {
			  drink[i] = Integer.parseInt(br.readLine());
			  dmin = Math.min(dmin, drink[i]);
		  }
		  
		  smin = bmin + dmin - 50;
		  
		  bw.write( String.valueOf(smin));
		  
		  bw.flush(); 
		  bw.close();
		
	}

}
