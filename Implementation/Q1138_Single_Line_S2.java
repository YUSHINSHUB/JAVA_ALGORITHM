package Implementation;

import java.io.*;
import java.math.BigInteger;
import java.util.*;



public class Q1138_Single_Line_S2 {

	int res[];
		
	public Q1138_Single_Line_S2(int res[]){
		this.res = res;
	}
	
	public static void swap( Q1138_Single_Line_S2 t, int a, int b ) {
		int temp = t.res[a];
		t.res[a] = t.res[b];
		t.res[b] = temp;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		String input[] = br.readLine().split(" ");
		
		
		
		int res[] = new int[n];
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(n);
		
		for( int i = 0 ; i < n ; i++ ) {
			res[i] = i+1;
			map.put(i+1, Integer.parseInt(input[i]));
		}
		
		Q1138_Single_Line_S2 a = new Q1138_Single_Line_S2(res);
		
		while( true ) {
			boolean chk = true;
		for( int i = 0 ; i < n ; i++ ) {
			int temp = 0;
			for( int z = 0 ; z < i ; z++ ) {
				if( a.res[z] > a.res[i] ) {
					temp++;
				}
			}
			if( map.get(a.res[i]) != temp ) {
				chk = false;
				int c = i;
				int x = i;
				while( temp != map.get(a.res[c]) ) {
					x++;
					if( a.res[x] > a.res[c] ) {
						temp++;
					}
					swap(a, x, c);
					c++;
				}
			}
		}
		
		if( chk == true ) break;
		
		}
		
		for( int i = 0 ; i < n ; i++ ) {
			bw.write(a.res[i] + " ");
		}
		
		bw.flush();
		bw.close();
	}
}
