package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

class top{
	int hei;
	int pos;
	
		top(int hei, int pos) {
		this.hei = hei;
		this.pos = pos;
	}
		
}

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<top> stk = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		
		String inp[] = br.readLine().split(" ");
		
		for( int i = 1 ; i <= n ; i++ ) {
			int t = Integer.parseInt(inp[i-1]);
			
			while( !stk.isEmpty() ) {
				if( stk.peek().hei > t ) break;
				else stk.pop();
			}
			
			if( stk.isEmpty() ) bw.write("0 ");
			else bw.write(stk.peek().pos + " ");
			
			stk.add(new top(t, i));
			
		}

		bw.flush();
		bw.close();

	}
}
