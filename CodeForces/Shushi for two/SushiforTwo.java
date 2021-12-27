import java.io.*;
import java.util.*;

public class SushiforTwo {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		int count1 = 1, count2 = 1, res = 0;
		int[] pieces = new int[n];
		for (int i = 0; i < n; i++) {
			pieces[i] = reader.nextInt();
		}
		for (int i = 1; i < n; i++) {
			if (pieces[i] == pieces[i - 1]) {
				if (pieces[i] == 2) {
					count2++;
				}
				if (pieces[i] == 1) {
					count1++;
				}
			}
			if (pieces[i] != pieces[i - 1]) {
				if (pieces[i] == 2) {
					res = Math.max(res, Math.min(count1, count2));
					count2 = 1;
				}
				if (pieces[i] == 1) {
					res = Math.max(res, Math.min(count1, count2));
					count1 = 1;
				}
			}
		}
		res = Math.max(res, Math.min(count1, count2)) * 2;
		System.out.println(res);

	}

	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}

}