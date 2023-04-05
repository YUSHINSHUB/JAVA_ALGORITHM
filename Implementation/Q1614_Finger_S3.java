package Implementation;

import java.io.*;

public class Q1614_Finger_S3 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		long res = 1;
		int cnt = 0;
		if( n == 1 ) cnt = 1;
		
		if( n == 1 && m == 0 ) res = 0;
		else {
		while( true ) {
			for( int i = 2 ; i <= 5 ; i++ ) {
				res++;
				if( i == n ) {
					cnt++;
					if( cnt > m ) break;
				}
			}
			if( cnt > m ) break;
			for( int i = 4 ; i >= 1 ; i-- ) {
				res++;
				if( i == n ) {
					cnt++;
					if( cnt > m ) break;
				}
			}
			if( cnt > m ) break;
		}
		
		res--;
		}
		bw.write(res + "");
		
		bw.flush();
		bw.close();
	}
}