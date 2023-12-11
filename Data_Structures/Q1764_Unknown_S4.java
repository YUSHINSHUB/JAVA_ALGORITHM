package Data_Structures;

import java.io.*;
import java.util.*;

public class Q1764_Unknown_S4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		String inp[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);
		
		String temp;
		
		for( int i = 0 ; i < n ; i++) {
			temp = br.readLine();
			hm.put(temp, hm.getOrDefault(temp, 0)+1 );
		}
		
		for( int i = 0 ; i < m ; i++) {
			temp = br.readLine();
			hm.put(temp, hm.getOrDefault(temp, 0)+1 );
		}
		
		HashSet<String> hs = new HashSet<String>();
		
		for (Map.Entry<String, Integer> entry : hm.entrySet()) {
			if (entry.getValue() == 2) hs.add(entry.getKey());
		}
		
		String out[] = hs.toArray(new String[0]);
		Arrays.sort(out);
		
		bw.write(out.length + "\n");
		for( int i = 0 ; i < out.length ; i++ ) bw.write(out[i] + "\n");
		
		bw.flush();
		bw.close();

	}
}