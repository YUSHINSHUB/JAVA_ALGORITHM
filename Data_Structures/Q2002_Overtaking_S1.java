package Data_Structures;

import java.io.*;
import java.util.*;

public class Q2002_Overtaking_S1{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int res = 0;
		HashMap<String, Integer> hm = new HashMap<String, Integer>(4);
		
		for( int i = 0 ; i < n ; i++ ) {
			hm.put(br.readLine(), i);
		}
		
		int out[] = new int[n];
		
		for( int i = 0 ; i < n ; i++ ) {
			out[i] = hm.get(br.readLine());
		}
		
		for( int i = 0 ; i < n ; i++ ) {
			for( int j = i + 1 ; j < n ; j++ ) {
				if( out[i] > out[j] ) {
					res++;
					break;
				}
			}
		}
		
		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}