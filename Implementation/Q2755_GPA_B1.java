package Implementation;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2755_GPA_B1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		double sum = 0;
		int cls = 0;
		
		for( int i = 0 ; i < n ; i++ ) {
			String inp[] = br.readLine().split(" ");
			if( inp[2].equals("A+")) {
				sum += Integer.parseInt(inp[1]) * 4.3;
			}else if( inp[2].equals("A0")) {
				sum += Integer.parseInt(inp[1]) * 4.0;
			}else if( inp[2].equals("A-")) {
				sum += Integer.parseInt(inp[1]) * 3.7;
			}else if( inp[2].equals("B+")) {
				sum += Integer.parseInt(inp[1]) * 3.3;
			}else if( inp[2].equals("B0")) {
				sum += Integer.parseInt(inp[1]) * 3.0;
			}else if( inp[2].equals("B-")) {
				sum += Integer.parseInt(inp[1]) * 2.7;
			}else if( inp[2].equals("C+")) {
				sum += Integer.parseInt(inp[1]) * 2.3;
			}else if( inp[2].equals("C0")) {
				sum += Integer.parseInt(inp[1]) * 2.0;
			}else if( inp[2].equals("C-")) {
				sum += Integer.parseInt(inp[1]) * 1.7;
			}else if( inp[2].equals("D+")) {
				sum += Integer.parseInt(inp[1]) * 1.3;
			}else if( inp[2].equals("D0")) {
				sum += Integer.parseInt(inp[1]) * 1.0;
			}else if( inp[2].equals("D-")) {
				sum += Integer.parseInt(inp[1]) * 0.7;
			}
			
			cls += Integer.parseInt(inp[1]);
		}
		
		sum /= cls;
		
		bw.write(String.format("%.2f", sum));
		
		bw.flush();
		bw.close();
	}
}
