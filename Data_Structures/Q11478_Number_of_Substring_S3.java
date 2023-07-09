package Data_Structures;

import java.io.*;
import java.util.*;

public class Q11478_Number_of_Substring_S3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in = br.readLine();

		HashSet<String> hset = new HashSet<String>();

		for (int i = 0; i < in.length(); i++) {
			String temp = "";
			for (int j = i; j < in.length(); j++) {
				temp += in.charAt(j);
				hset.add(temp);
			}
		}

		bw.write(hset.size() + "");
		bw.flush();
		bw.close();
	}
}
