package Geometry;

import java.io.*;
import java.util.*;

public class Q3053_Taxi_Geometry_B3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int r = Integer.parseInt(br.readLine());

		double uc = (double) r * (double) r * Math.PI;
		int tx = r * r * 2;

		bw.write(String.valueOf(uc) + "\n" + String.valueOf(tx));

		bw.flush();
		bw.close();

	}
}