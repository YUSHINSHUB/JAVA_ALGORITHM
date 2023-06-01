package Implementation;

import java.io.*;

public class Q1252_Binary_Addition_B2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		String bina = inp[0];
		String binb = inp[1];
		
		if( bina.length() < binb.length() ) {
			String temp = bina;
			bina = binb;
			binb = temp;
		}
		
		StringBuilder a = new StringBuilder(bina);
		StringBuilder b = new StringBuilder(binb);
	
		int gap = bina.length() - binb.length();
		int idx;
		
		for( int i = binb.length()-1 ; i >= 0 ; i-- ) {
			if( binb.charAt(i) == '1' ) {
				idx = i + gap;
				while( a.charAt(idx) == '1' && idx > 0 ) {
					a.setCharAt(idx, '0');
					idx--;
				}
				if( idx == 0 && a.charAt(idx) == '1') {
					a.setCharAt(0, '0');
					a = new StringBuilder("1" + a.toString());
					gap++;
				}
				else a.setCharAt(idx, '1');
			}
		}
		
		String res = a.toString();
		while( res.length() > 1 && res.charAt(0) == '0' ) {
			res = res.substring(1);
		}
		
		bw.write(res);

		bw.flush();
		bw.close();

	}
}
