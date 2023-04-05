package Bruteforcing;

import java.io.*;

public class Q4375_1_S3{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in;
		int n;
		int idx = 1;
		int temp = 0;
		
		while( (in = br.readLine()) != null ) {
			n = Integer.parseInt(in);
			idx = 1;
			temp = 1 % n;
			
			while( temp != 0 ) {
				temp = ( ( (temp * 10) % n ) + 1 ) % n;
				idx++;
			}
			bw.write( idx + "\n" );
			bw.flush();
		}
		bw.close();
	
		}
}