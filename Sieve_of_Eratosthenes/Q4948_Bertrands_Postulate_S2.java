package Sieve_of_Eratosthenes;

import java.io.*;

public class Q4948_Bertrands_Postulate_S2{
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	    int cnt[] = new int[246914];
	    int chk[] = new int[246914];
	    int idx = 1;
	    cnt[1] = 0;
	    cnt[2] = 1;

	    chk[1] = 1;
	    chk[2] = 2;

	    for (int i = 4; i <= 246913; i += 2) {
	        chk[i] = 1;
	    }

	    for (int i = 3; i <= 246913; i++) {
	        if (chk[i] != 1) {
	            idx++;
	            chk[i] = 2;
	            for (int z = i * 2; z <= 246913; z += i) {
	                chk[z] = 1;
	            }
	        }
	        cnt[i] = idx;
	    }

	    int n;
	    while (true) {
	        n = Integer.parseInt(br.readLine());
	        if (n == 0) break;
	        bw.write(cnt[n * 2] - cnt[n] + "\n");
	    }
		
		bw.flush();
		bw.close();

	}
}
