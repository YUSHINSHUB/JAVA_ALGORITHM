package Implementation;

import java.io.*;
import java.util.*;
import java.text.*;

public class Q5355_Mars_Math_B2 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		DecimalFormat df = new DecimalFormat("#.00");
		int n = Integer.parseInt(br.readLine());
		double res;
		String c;
		
		for( int i = 0 ; i < n ; i++ ) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			res = Double.parseDouble(stk.nextToken());
			while(stk.hasMoreTokens()) {
				c = stk.nextToken();
				if( c.equals("@") ) res *= 3;
				else if( c.equals("%")) res += 5;
				else res -= 7;
			}
			bw.write(df.format(res) + "\n");
		}
		
		bw.flush();
		bw.close();
		
	}
}
