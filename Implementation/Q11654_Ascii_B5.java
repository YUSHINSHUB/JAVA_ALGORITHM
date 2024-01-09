package Implementation;

import java.io.*;
import java.util.*;

public class Q11654_Ascii_B5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char a = (char) System.in.read();
		int n = a;

		bw.write(String.valueOf(n));

		bw.flush();
		bw.close();
	}

}
