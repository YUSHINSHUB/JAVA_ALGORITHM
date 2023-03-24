package Implementation;

import java.io.*;

public class Q1550_Hex_B2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
			
		String hex = br.readLine();
		
		int res = Integer.parseInt(hex, 16);
		//Integer.parseInt(string, 진수)를 입력해서 원하는 수를 10진수로 변환 가능
		
		bw.write(String.valueOf(res));
		
		bw.flush();
		bw.close();
		
	}

}