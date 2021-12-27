import java.io.*;
import java.util.*;

public class AliceBobAndChocolate {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		int[] time = new int[n];
		for (int i = 0; i < n; i++) {
			time[i] = reader.nextInt();
		}
		int countA = 0, countTimeA = 0;
		int countB = 0, countTimeB = 0;
		int count = 0;
		for (int i = 0, j = n - 1; count < n; count++) {
			if (countTimeA == countTimeB) {
				countA++;
				countTimeA += time[i];
				i++;
			} else if (countTimeA > countTimeB) {
				countB++;
				countTimeB += time[j];
				j--;
			} else {
				countA++;
				countTimeA += time[i];
				i++;
			}
		}
		System.out.print(countA + " " + countB);
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