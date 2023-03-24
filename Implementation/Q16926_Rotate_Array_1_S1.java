package Implementation;

import java.io.*;
import java.math.*;
import java.util.*;



public class Q16926_Rotate_Array_1_S1 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String in[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(in[0]);
		int m = Integer.parseInt(in[1]);
		int r = Integer.parseInt(in[2]);
		int cnt = 0;
		
		int arr[][] = new int[n][m];
		
		for( int i = 0 ; i < n ; i++ ) {
			String temp[] = br.readLine().split(" ");
			for( int z = 0 ; z < m ; z++ ) {
				arr[i][z] = Integer.parseInt(temp[z]);
			}
		}
		
		for( int i = 0 ; i < r ; i++ ) {
			cnt = 0;
			while( cnt < n/2 && cnt < m/2 ) {
			int temp = arr[cnt][cnt]; 
			for( int z = cnt+1 ; z < m-cnt ; z++ ) {
				arr[cnt][z-1] = arr[cnt][z];
			} // 제일 위 가로줄
			
			for( int z = cnt+1 ; z < n-cnt ; z++ ) {
				arr[z-1][m-1-cnt] = arr[z][m-1-cnt];
			} // 제일 오른쪽 세로줄
			
			for( int z = m-1-cnt ; z > cnt ; z-- ) {
				arr[n-1-cnt][z] = arr[n-1-cnt][z-1];
			} // 제일 밑 가로줄
			
			for( int z = n-1-cnt ; z > cnt ; z-- ) {
				arr[z][cnt] = arr[z-1][cnt];
			}
			// 제일 왼쪽 세로줄
			
			arr[cnt+1][cnt] = temp;
			
			cnt++;
			
			}
		}
		
		for( int i = 0 ; i < n ; i++ ) {
			for( int z = 0 ; z < m ; z++ ) {
				bw.write(arr[i][z] + " ");;
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
}
