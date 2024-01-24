package aaNotepad;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Pok {

	static int idx = 0;
	static ArrayList<pokemon> pok = new ArrayList<>();

	static class pokemon {
		int no;
		String name;
		String item;
		ArrayList<String> weak = new ArrayList<>();
		ArrayList<String> anti = new ArrayList<>();

		pokemon(int no, String name, String item) {
			this.no = no;
			this.name = name;
			this.item = item;
		}

		void addw(String weak) {
			this.weak.add(weak);
		}

		void adda(String anti) {
			this.anti.add(anti);
		}
	}

	static void init() throws IOException {

		String str, name, item;
		int no;
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\dbtls\\Desktop\\pok.txt"));
		while (!(str = reader.readLine()).equals("end")) {
			String inp[] = str.split(" ");
			no = Integer.parseInt(inp[0]);
			name = inp[1];
			item = inp[2];
			pokemon temp = new pokemon(no, name, item);
			inp = reader.readLine().split(" ");
			for (int i = 0; i < inp.length; i++)
				temp.addw(inp[i]);
			inp = reader.readLine().split(" ");
			for (int i = 0; i < inp.length; i++)
				temp.adda(inp[i]);
			pok.add(temp);
			idx++;
			str = reader.readLine();
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		init();
		ArrayList<Integer> except = new ArrayList<Integer>();
		ArrayList<String> e = new ArrayList<String>();
		Boolean p0;

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < idx; i++) {
			p0 = false;
			pokemon a = pok.get(i);
			if (except.contains(a.no) || e.contains(a.item))
				continue;
			for (int j = i + 1; j < idx; j++) {
				Boolean pass = false;
				pokemon b = pok.get(j);
				if (except.contains(b.no) || e.contains(b.item) || a.no == b.no)
					continue;
				for (int k = 0; k < a.weak.size(); k++) {
					if (b.anti.contains(a.weak.get(k))) {
						pass = true;
						break;
					}
				}
				if (!pass)
					continue;
				for (int k = 0; k < a.weak.size(); k++) {
					if (b.weak.contains(a.weak.get(k))) {
						pass = false;
						break;
					}
				}
				if (pass) {
					for (int k = j + 1; k < idx; k++) {
						pass = false;
						pokemon c = pok.get(k);
						if (except.contains(c.no) || e.contains(c.item) || b.no == c.no)
							continue;
						for (int l = 0; l < a.weak.size(); l++) {
							if (c.anti.contains(a.weak.get(l))) {
								pass = true;
								break;
							}
						}
						if (!pass)
							continue;
						pass = false;

						for (int l = 0; l < b.weak.size(); l++) {
							if (c.anti.contains(b.weak.get(l))) {
								pass = true;
								break;
							}
						}
						if (!pass)
							continue;

						for (int l = 0; l < c.weak.size(); l++) {
							if (b.weak.contains(c.weak.get(l)) || a.weak.contains(c.weak.get(l))) {
								pass = false;
								break;
							}
						}
						if (pass) {
							except.add(a.no);
							except.add(b.no);
							except.add(c.no);
							e.add(a.item);
							e.add(b.item);
							e.add(c.item);
							sb.append(a.name + " @" + a.item + "\n" + b.name + " @" + b.item + "\n" + c.name + " @" + c.item
									+ "\n\n");
							p0 = true;
						}
						if (p0)
							break;
					}
				}
				if (p0)
					break;
			}
			if (p0)
				continue;
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
