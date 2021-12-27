import java.io.*;
import java.util.*;

public class VerseForSanta {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int t = reader.nextInt();
		StringBuilder outBuffer = new StringBuilder();
		while (t-- > 0) {
			int n = reader.nextInt();
			int s = reader.nextInt();
			int[] parts = new int[n];
			for (int i = 0; i < n; i++) {
				parts[i] = reader.nextInt();
			}
			int position = 0;
			int max = Integer.MIN_VALUE;
			int sum = 0;
			boolean skip = true;
			for (int i = 0; i < n; i++) {
				if (sum <= s) {
					sum += parts[i];
					if (parts[i] > max && skip) {
						position = i;
						max = parts[i];
					}
					if (sum > s && skip) {
						skip = false;
						sum -= parts[position];
					}
				} else
					break;
				if (i == n - 1 && sum <= s && skip)
					position = -1;
			}
			int result = position + 1;
			outBuffer.append(result + " ");
		}
		System.out.print(outBuffer);

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