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
		  //��� ���� �ִ�ġ�� 4,000,000,000�̱� ������ int�� ������ �ʰ��ϹǷ� long���� �Է��Ѵ�.
		  
		  bw.write(String.valueOf(Math.abs(n - m)));
		  //Math.abs() �޼ҵ�� ������ ���밪�� ��ȯ���ش�.
		  
		  bw.flush(); 
		  bw.close();
		
	}

}