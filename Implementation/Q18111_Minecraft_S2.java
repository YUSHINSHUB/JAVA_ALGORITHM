package Implementation;

import java.io.*;

public class Q18111_Minecraft_S2 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String inp[] = br.readLine().split(" ");
		int n, m, b;
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		b = Integer.parseInt(inp[2]);
		
		int pos[][] = new int[n][m];
		int maxf = 0;
		
		for( int i = 0 ; i < n ; i++ ) {
			String temp[] = br.readLine().split(" ");
			for( int z = 0 ; z < m ; z++ ) {
				pos[i][z] = Integer.parseInt(temp[z]);
				if( pos[i][z] > maxf ) maxf = pos[i][z];
			}
		}
		
		int res[] = new int[maxf+1];
		int floor = 0;
		int temp = 0;
		int lotime = 2000000000;
		int pfl = 0;
		
		while( floor <= maxf ) {
			temp = b;
			for( int i = 0 ; i < n ; i++ ) {
				for( int z = 0 ; z < m ; z++ ) {
					if( pos[i][z] > floor ) { 
						res[floor] += (pos[i][z] - floor) * 2;
						temp += pos[i][z] - floor;
					}else if( pos[i][z] < floor ) {
						res[floor] += floor - pos[i][z];
						temp -= floor - pos[i][z];
					}
				}
			}
			if( temp >= 0 && res[floor] <= lotime ) {
				lotime = res[floor];
				pfl = floor;
				}
			floor++;
		}
		
		bw.write(String.valueOf(lotime) + " " + String.valueOf(pfl));
		
		bw.flush();
		bw.close();
		
	}
}