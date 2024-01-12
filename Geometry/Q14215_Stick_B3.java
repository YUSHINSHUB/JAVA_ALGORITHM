package Geometry;

import java.io.*;
import java.util.*;

public class Q14215_Stick_B3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int arr[] = new int[3];
		String inp[] = br.readLine().split(" ");
		arr[0] = Integer.parseInt(inp[0]);
		arr[1] = Integer.parseInt(inp[1]);
		arr[2] = Integer.parseInt(inp[2]);

		Arrays.sort(arr);

		if (arr[0] + arr[1] <= arr[2])
			arr[2] = arr[0] + arr[1] - 1;

		bw.write(arr[0] + arr[1] + arr[2] + "");

		bw.flush();
		bw.close();

	}
}