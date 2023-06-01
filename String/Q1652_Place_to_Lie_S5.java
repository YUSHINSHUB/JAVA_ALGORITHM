package String;

import java.io.*;

public class Q1652_Place_to_Lie_S5 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		String room[] = new String[n];
		int cnt = 0;
		int x = 0;
		int y = 0;
		
		for( int i = 0 ; i < n ; i++ ) {
			room[i] = br.readLine();
			cnt = 0;
			for( int j = 0 ; j < n ; j++ ) {
				if( room[i].charAt(j) == '.' ) {
					cnt++;
				}else {
					if( cnt >= 2 ) x++;
					cnt = 0;
				}
			}
			if( cnt >= 2 ) x++;
		}
		
		for( int i = 0 ; i < n ; i++ ) {
			cnt = 0;
			for( int j = 0 ; j < n ; j++ ) {
				if( room[j].charAt(i) == '.' ) {
					cnt++;
				}else {
					if( cnt >= 2 ) y++;
					cnt = 0;
				}
			}
			if( cnt >= 2 ) y++;
		}
		
		bw.write(x + " " + y);

		bw.flush();
		bw.close();

	}
}
