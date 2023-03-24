package Implementation;

import java.io.*;

public class Q2439_Star_Drawing_2_B4 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int star = Integer.parseInt(br.readLine());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for( int a = 1 ; a <= star ; a++ ) {
			for( int b = 0 ; b < star - a ; b++ ) {
				bw.write(" ");
			}
			//우측정렬을 해야되기 떄문에 가로길이 (star)에서 찍을 별의개수 (a)를 뺸만큼 공백을 출력한다.
			for( int c = 0 ; c < a ; c++ ) {
				bw.write("*");
			}
			//공백 뒤에 별을 출력하여 우측정렬을 표현한다.
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		
	}

}
