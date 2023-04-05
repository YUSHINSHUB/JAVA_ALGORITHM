package Ad_hoc;

import java.io.*;

public class Q10219_Meats_On_The_Grill_B1 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		int w, h;
		
		for (int i = 0 ; i < t ; i++ ) {
			String wh[] = br.readLine().split(" ");
			w = Integer.parseInt(wh[1]);
			h = Integer.parseInt(wh[0]);
			
			char m[][] = new char[w][h];
			for( int z = 0 ; z < h ; z++ ) {
				String temp = br.readLine();
				for( int x = 0 ; x < w ; x++ ) {
					m[x][z] = temp.charAt(x);
				}
			}
			
			for( int z = 0 ; z < h ; z++ ) {
				for( int x = w-1 ; x >= 0 ; x-- ) {
					bw.write(Character.toString(m[x][z]));
				}

				bw.write("\n");
			}
			
			
		}
		
		bw.flush();
		bw.close();
}
}
