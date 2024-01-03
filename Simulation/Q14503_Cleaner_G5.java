package Simulation;

import java.io.*;

public class Q14503_Cleaner_G5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		
		int x = Integer.parseInt(inp[0]);
		int y = Integer.parseInt(inp[1]);
		
		String rcd[] = br.readLine().split(" ");
		int r = Integer.parseInt(rcd[0]);
		int c = Integer.parseInt(rcd[1]);
		int d = Integer.parseInt(rcd[2]);
		
		int pos[][] = new int[x][y];
		
		for( int i = 0 ; i < x ; i++ ) {
			inp = br.readLine().split(" ");
			for( int j = 0 ; j < y ; j++ ) {
				pos[i][j] = Integer.parseInt(inp[j]);
			}
		}
		
		int res = 1;
		pos[r][c] = 2;
		boolean out = false;
		
		while( true ) {

			if( ( pos[r-1][c] == 2 || pos[r-1][c] == 1 ) && ( pos[r+1][c] == 2 || pos[r+1][c] == 1 ) 
					&& ( pos[r][c-1] == 2 || pos[r][c-1] == 1 ) && ( pos[r][c+1] == 2 || pos[r][c+1] == 1 ) ) {
				switch(d) {
				case 0:
					if( pos[r+1][c] == 1 ) out = true;
					else r++;
					break;
				case 1:
					if( pos[r][c-1] == 1 ) out = true;
					else c--;
					break;
				case 2:
					if( pos[r-1][c] == 1 ) out = true;
					else r--;
					break;
				case 3:
					if( pos[r][c+1] == 1 ) out = true;
					else c++;
					break;
				}
				if( !out ) {
					continue;
				}
			}
			
			if( out ) break;
			
			switch(d) {
			case 0:
					if( pos[r][c-1] == 0 ) {
						d = 3;
						c--;
						pos[r][c] = 2;
						res++;
					}else {
						d = 3;
					}
					break;
			case 1:
				if( pos[r-1][c] == 0 ) {
					r--;
					d = 0;
					pos[r][c] = 2;
					res++;
				}else {
					d = 0;
				}
				break;
		case 2:
			if( pos[r][c+1] == 0 ) {
				c++;
				d = 1;
				pos[r][c] = 2;
				res++;
			}else {
				d = 1;
			}
			break;
		case 3:
			if( pos[r+1][c] == 0 ) {
				r++;
				d = 2;
				pos[r][c] = 2;
				res++;
			}else {
				d = 2;
			}
			break;
			}
		}
		
		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}
