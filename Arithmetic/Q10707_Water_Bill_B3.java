package Arithmetic;

import java.io.*;

public class Q10707_Water_Bill_B3 {
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int xpl = Integer.parseInt(br.readLine());
		int yff = Integer.parseInt(br.readLine());
		int yfl = Integer.parseInt(br.readLine());
		int ypl = Integer.parseInt(br.readLine());
		int jwu = Integer.parseInt(br.readLine());
		
		int xfee = xpl * jwu;
		int yfee;
		
		int low;
		
		if( jwu <= yfl ) {
			yfee = yff;
		}else {
			jwu -= yfl;
			yfee = yff + (jwu * ypl);
		}
		
		low = Math.min(xfee,  yfee);

		
		
		bw.write(String.valueOf(low));
		
		bw.flush();
		bw.close();
		
	}

}