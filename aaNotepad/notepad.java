package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String inp[] = br.readLine().split(" ");
		double a1 = Double.parseDouble(inp[0]);
		double p1 = Double.parseDouble(inp[1]);
		
		inp = br.readLine().split(" ");
		double a2 = Double.parseDouble(inp[0]);
		double p2 = Double.parseDouble(inp[1]);
		
		a1 = a1 / p1;
		a2 = (Math.pow(a2, 2) * Math.PI) / p2;
		
		if( a1 > a2 ) {
			bw.write("Slice of pizza");
		}else {
			bw.write("Whole pizza");
		}
		
		bw.flush();
		bw.close();
	}
}
