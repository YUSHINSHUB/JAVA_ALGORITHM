package String;

import java.io.*;
import java.util.*;

public class Q11719_Keep_Input_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String temp;

		while ((temp = br.readLine()) != null) {
			bw.write(temp + "\n");
			bw.flush();
		}
		bw.close();

	}
}