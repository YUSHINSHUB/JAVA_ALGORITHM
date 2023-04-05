package Sorting;

import java.io.*;

public class Q10816_Number_Card_2_S4 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cards[] = new int[20000001];
		
		int n =  Integer.parseInt(br.readLine());
		String in[] = br.readLine().split(" ");
		
		for( int i = 0 ; i < n ; i++ ) {
			cards[Integer.parseInt(in[i])+10000000]++;
		}
		
		n = Integer.parseInt(br.readLine());
		in = br.readLine().split(" ");
		
		for( int i = 0 ; i < n ; i++ ) {
			bw.write(cards[Integer.parseInt(in[i])+10000000] + " ");
		}
		
		bw.flush();
		bw.close();

	}
}
