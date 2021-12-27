import java.io.*;
import java.util.*;

public class AFrank {

	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = reader.nextInt();
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			int j = i + 1;
			int count = 1;
			while (j < n && ar[j] == ar[j - 1] + 1) {
				j++;
				count++;
			}
			int len = ar[j - 1] - ar[i] - 1;
			if (i == 0 && ar[i] == 1)
				len++;

			if (j == n && ar[j - 1] == 1000)
				len++;
			max = Math.max(max, len);
		}
		System.out.println(max);
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