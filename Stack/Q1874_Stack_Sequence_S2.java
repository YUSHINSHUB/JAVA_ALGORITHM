package Stack;

import java.io.*;
import java.util.*;

public class Q1874_Stack_Sequence_S2 {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Integer> stk = new Stack<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		char[] out = new char[n*2];
		int outcnt = 0;
		int cnt = 1;
		int numcnt = 0;
		int stkcnt = 0;
		
		boolean suc = true;
		
		for( int i = 0 ; i < n ; i++ ) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		while( numcnt < n ) {
			
			if( nums[numcnt] >= cnt) {
			while( nums[numcnt] >= cnt ) {
				stk.push(cnt);
				cnt++;
				out[outcnt] = '+';
				outcnt++;
			}
			}else {
				if( stk.isEmpty() ) {
					suc = false;
					break;
				}
				while( stk.peek().intValue() != nums[numcnt] ) {
					stk.pop();
					out[outcnt] = '-';
					outcnt++;
					if( stk.isEmpty() ) {
						suc = false;
						break;
					}
				}
			}
			
			
			
			if( suc == false ){
				break;
			}else if( stk.peek().intValue() == nums[numcnt] ) {
				stk.pop();
				out[outcnt] = '-';
				outcnt++;
			}
			
			numcnt++;
			
		}
		
		if( suc == true ) {
			for( int i = 0 ; i < outcnt ; i++ ) {
				bw.write(out[i] + "\n");
			}
		}else {
			bw.write("NO");
		}
		
		bw.flush();
		bw.close();
		
	}
}
