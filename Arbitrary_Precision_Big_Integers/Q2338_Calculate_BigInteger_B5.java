package Arbitrary_Precision_Big_Integers;

import java.io.*;
import java.math.*;

public class Q2338_Calculate_BigInteger_B5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
		
		String list[] = new String[2];
		list[0] = br.readLine();
		list[1] = br.readLine();
		
		BigInteger a = new BigInteger(list[0]);
		BigInteger b = new BigInteger(list[1]);
		
		bw.write( a.add(b) + "\n" + a.subtract(b) + "\n" + a.multiply(b) );
		
				
		bw.flush();
		bw.close();
	}

}
