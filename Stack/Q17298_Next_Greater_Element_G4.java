package Data_Structures;

import java.io.*;
import java.util.*;


public class Q17298_Next_Greater_Element_G4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean chk = true;
		int n = Integer.parseInt(br.readLine());
		String in[] = br.readLine().split(" ");
		int num[] = new int[n];
		
		Stack stk = new Stack<Integer>();
		
		for( int i = 0 ; i < n ; i++ ) {
			num[i] = Integer.parseInt(in[i]);
		}
		
		int cnt = 1;
		
		while(true) {
			if( stk.isEmpty() ) {
				stk.push(cnt);
				cnt++;
				if( cnt > n ) {
					break;
				}
			}else {
				if( num[(int)(stk.peek())-1] < num[cnt-1] ) {
					num[(int)stk.pop()-1] = num[cnt-1];
				}else {
					stk.push(cnt);
					cnt++;
					if( cnt > n ) {
						break;
					}
				}
			}
		}
		
		while( !stk.isEmpty() ) {
			num[(int)stk.pop()-1] = -1;
		}
		
		for( int i = 0 ; i < n ; i++ ) {
			bw.write(String.valueOf(num[i]) + " ");
		}
		
		bw.flush();
        bw.close();

	
}
}
