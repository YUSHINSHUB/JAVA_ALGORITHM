package Data_Structures;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q4358_Ecology_S2 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String trees[] = new String[1000001];
		String in;
		int cnt = 0;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		while( (in = br.readLine()) != null ) {
			if( in.equals("break")) break;
			trees[cnt] = in;
			hm.put(in, 0);
			cnt++;
		}
		
		for( int i = 0 ; i < cnt ; i++ ) {
			hm.put(trees[i], hm.get(trees[i])+1);
		}
		
		HashSet<String> hs = new HashSet<String>(Arrays.asList(trees));
		hs.remove(null);
		trees = hs.toArray(new String[0]);
		
		Arrays.sort(trees, (o1, o2) -> {
			for( int i = 0 ; i < Math.min(o1.length(), o2.length()) ; i++ ) {
				if( o1.charAt(i) != o2.charAt(i) ) return Integer.compare(o1.charAt(i), o2.charAt(i));
			}
			return Integer.compare(o1.length(), o2.length());
		});
		
		for( int i = 0 ; i < trees.length ; i++ ) {
			double res = Math.round((double)hm.get(trees[i]) / cnt * 100 * 10000)/10000.0;
			bw.write(trees[i] + " " + String.format("%.4f", res) + "\n"  );
		}
		
		
		bw.flush();
		bw.close();
	}
}