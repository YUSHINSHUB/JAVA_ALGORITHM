package Arithmetic;

import java.io.*;

public class Q5543_Sangdonald_B4 {
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		
		  BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		  BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
		  
		  int bmin = 2001;
		  int dmin = 2001;
		  //���� �޴��� ������ 2000���� ���� ���� �ʴ´ٴ� ������ �ֱ� ������
		  // for�ݺ����� ������ ���� �Ǵ� ������ ù���� ������ min�� ���ԵǱ� ���� 2001�� �������ش�.
		  
		  int smin;
		  
		  int burger[] = new int[3];
		  int drink[]  = new int[2];
		  
		  for( int i = 0 ; i < 3 ; i++ ) {
			  burger[i] = Integer.parseInt(br.readLine());
			  bmin = Math.min(bmin, burger[i]);
			  // Math.min( int, int ) �޼ҵ�� �� ������ ���� ���� ��ȯ�Ѵ�.
			  //�ݴ�� Math.max�� ū ���� ��ȯ�Ѵ�.
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
