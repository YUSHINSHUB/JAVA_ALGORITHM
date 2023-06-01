package Mathematics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1011_Fly_me_to_the_Alpha_Centauri_G5 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		int x, y;
		int cnt = 0;
		int spd = 1;
		int pos = 0;
		int res = 0;
		
		for( int i = 0 ; i < t ; i++ ) {
			res = 0;
			spd = 0;
			String inp[] = br.readLine().split(" ");
			x = Integer.parseInt(inp[0]);
			y = Integer.parseInt(inp[1]);
			y -= x; // y는 거리
			pos = 0; // 현재위치
			while( pos < ((double)y/2) ) {
				spd++;
				pos += spd;
				res++;
			}
			
			pos -= spd;
			spd--;
			res--;
			res *= 2;
			
			if( y - (pos*2) > spd+1 ) {
				res += 2;
			}else {
				res += 1;
			}
			
			bw.write(res + "\n");
			
		}
		
		bw.flush();
		bw.close();
	}
}