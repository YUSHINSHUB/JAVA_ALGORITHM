package Euclidean_Algorithm;

import java.io.*;

public class Q3036_Ring_S4 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		String inp[] = br.readLine().split(" ");
		int fir = Integer.parseInt(inp[0]);
		for( int i = 1 ; i < t ; i++ ) {
			int a = fir;
			int b = Integer.parseInt(inp[i]);
			int r = a % b;
				
			while( true ) {
				r = a % b;
				if( r == 0 ) break;
					a = b;
					b = r;	
					
				}
				
				bw.write( (int)(fir/b) + "/" + (int)(Integer.parseInt(inp[i])/b) + "\n");
			
		}
		
		
		bw.flush();
		bw.close();
	}
}
