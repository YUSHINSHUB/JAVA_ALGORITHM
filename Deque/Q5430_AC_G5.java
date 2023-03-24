package Deque;

import java.io.*;
import java.util.*;

public class Q5430_AC_G5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Deque<Integer> dq = new LinkedList<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		int p = 0;
		String ac, inp;
		char c;
		boolean err = false;
		boolean rev = false;
		
		for( int i = 0 ; i < n ; i++ ) {
			ac = br.readLine();
			p = Integer.parseInt(br.readLine());
			inp = br.readLine();
			inp = inp.substring(1, inp.length()-1);
			String nums[] = inp.split(",");
			
			if( !inp.equals("") ) {
				for( int j = 0 ; j < nums.length ; j++ ) {
					dq.addLast(Integer.parseInt(nums[j]));
				}
			}
			err = false;
			
			for( int j = 0 ; j < ac.length() ; j++ ) {
				if( ac.charAt(j) == 'R' ) { 
					if( rev ) rev = false;
					else rev = true;
				}else {
					if( dq.isEmpty() ) {
						err = true;
						break;
					}
					else if( rev ) dq.pollLast();
					else dq.pollFirst();
				}
			}
			
			if(err) bw.write("error\n");
			else if( !rev ){
				bw.write("[");
				if( !dq.isEmpty() ) bw.write(dq.pollFirst() + ""); 
				while( !dq.isEmpty() ) {
					bw.write("," + dq.pollFirst());
				}
				bw.write("]\n");
			}else {
				bw.write("[");
				if( !dq.isEmpty() ) bw.write(dq.pollLast() + ""); 
				while( !dq.isEmpty() ) {
					bw.write("," + dq.pollLast());
				}
				bw.write("]\n");
			}
			
		}
			
		bw.flush();
		bw.close();
		
		}
}
