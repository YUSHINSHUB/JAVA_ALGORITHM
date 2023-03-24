package Implementation;

import java.io.*;
import java.math.*;

public class Q1009_Distributed_Processing_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for( int i = 0 ; i < t ; i++ ) {
			String[] x = br.readLine().split(" ");
			int a = Integer.parseInt(x[0]);
			int b = Integer.parseInt(x[1]);
			
			int res = 1;
			
			for( int z = 0 ; z < b ; z++ ) {
				res = (res * a) % 10;
				if( res == 0 ) {
					res = 10;
				}
			}
			
			bw.write(String.valueOf(res) + "\n");
			
		}
		
		bw.flush();
		bw.close();

	}

}
