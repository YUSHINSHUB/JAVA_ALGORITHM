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
			//���������� �ؾߵǱ� ������ ���α��� (star)���� ���� ���ǰ��� (a)�� �A��ŭ ������ ����Ѵ�.
			for( int c = 0 ; c < a ; c++ ) {
				bw.write("*");
			}
			//���� �ڿ� ���� ����Ͽ� ���������� ǥ���Ѵ�.
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		
	}

}
