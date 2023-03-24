package Geometry;

import java.io.*;
import java.math.*;
import java.util.*;

class pos{
	
	int x;
	int y;
	
	pos(int x, int y){
		this.x = x;
		this.y = y;
	}
	
}

public class Q3009_Fourth_Point_B3 {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		pos[] p = new pos[3]; 
		
		int x;
		int y;
		
		for( int i = 0 ; i < 3 ; i++ ) {
			String[] temp = br.readLine().split(" ");
			p[i] = new pos(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
			//JAVA에서는 클래스의 객체 배열을 먼저 선언한 후 각 요소를 후에 따로따로 선언할 수 있다.
		}
		
		if( p[1].x == p[0].x ) {
			x = p[2].x;
		}else if( p[2].x == p[0].x ) {
			x = p[1].x;
		}else {
			x = p[0].x;
		}
		
		if( p[1].y == p[0].y ) {
			y = p[2].y;
		}else if( p[2].y == p[0].y ) {
			y = p[1].y;
		}else {
			y = p[0].y;
		}
		
		bw.write(String.valueOf(x) + " " + String.valueOf(y));
		
		bw.flush();
		bw.close();
		
	}
}
