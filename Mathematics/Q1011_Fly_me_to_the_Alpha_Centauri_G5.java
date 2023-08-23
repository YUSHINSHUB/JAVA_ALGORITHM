package Mathematics;

//Commented by ChatGPT
//This program determines the minimum number of times the ship has to increase its speed to cover a given distance.

import java.io.*;

public class Q1011_Fly_me_to_the_Alpha_Centauri_G5 {

	public static void main(String[] args) throws IOException {

		// Setting up the buffered readers and writers for I/O operations
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Reading the number of test cases
		int t = Integer.parseInt(br.readLine());

		int x, y; // Starting and ending positions of the ship
		int spd = 1; // The current speed of the ship
		int pos = 0; // Current position of the ship
		int res = 0; // Result - the minimum number of times speed needs to be increased

		// Loop for each test case
		for (int i = 0; i < t; i++) {
			res = 0; // Reset the result for each test case
			spd = 0; // Reset the speed for each test case
			String inp[] = br.readLine().split(" ");
			x = Integer.parseInt(inp[0]);
			y = Integer.parseInt(inp[1]);

			y -= x; // Calculating the total distance to be traveled

			// Logic to determine the mid-point of the total distance
			// and then calculate the times speed needs to be increased
			while (pos < ((double) y / 2)) {
				spd++;
				pos += spd;
				res++;
			}

			pos -= spd;
			spd--;
			res--;
			res *= 2;

			// Adjusting the result based on the remaining distance to be covered
			if (y - (pos * 2) > spd + 1) {
				res += 2;
			} else {
				res += 1;
			}

			// Writing the result to the output for each test case
			bw.write(res + "\n");
		}

		// Flushing and closing the buffered writer
		bw.flush();
		bw.close();
	}
}
