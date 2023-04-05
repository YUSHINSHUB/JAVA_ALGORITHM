package Number_Theory;

import java.io.*;


public class Q17103_Goldbach_Conjecture_S2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean n[] = new boolean[1000001];
		
		n[0] = true;
		n[1] = true;
		
		for( int i = 2 ; i < 1000001 ; i++ ) {
			if( n[i] == false ) {
				for( int z = i * 2 ; z < 1000001 ; z+=i ) {
					n[z] = true;
				}
			}
		}
		
		int t = Integer.parseInt(br.readLine());
		int num[] = new int[t];
		int gold[] = new int[t];
		
		for( int i = 0 ; i < t ; i++ ) {
			num[i] = Integer.parseInt(br.readLine());
			gold[i] = 0;
			for( int z = 2 ; z <= num[i] / 2 ; z++ ) {
				if( n[z] == false && n[num[i]-z] == false) {
					gold[i]++;
				}
			}
			bw.write(String.valueOf(gold[i]) + "\n");
		}
		
	
		
		bw.flush();
        bw.close();

	
}
}
