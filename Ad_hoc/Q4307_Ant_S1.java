package Ad_hoc;

import java.io.*;
import java.math.BigInteger;
import java.util.*;



public class Q4307_Ant_S1 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int max, min;
		
		for( int i = 0 ; i < n ; i++ ) {
			String in[] = br.readLine().split(" ");
			int l = Integer.parseInt(in[0]);
			int a = Integer.parseInt(in[1]);
			double pos[] = new double[a];
			for( int z = 0 ; z < a ; z++ ) {
				pos[z] = Integer.parseInt(br.readLine());
			}
			

			Arrays.sort(pos);
			
			
			max = 0;
			min = (int)pos[0];
			
			
			for( int z = 0 ; z < a ; z++ ) {
				if( pos[z] < l / 2 ) min = (int)Math.max(pos[z], min);
				else min = (int)Math.max(l-pos[z], min);
			}
			
			max = (int)Math.max( ( pos[a-1] - pos[0] ) + (l-pos[a-1]), ( pos[a-1] - pos[0] ) + (pos[0]) ) ;
			
			bw.write(min + " " + max + "\n");
		}
		bw.flush();
		bw.close();
	}
}
