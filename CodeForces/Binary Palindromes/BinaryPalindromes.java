import java.io.*;
import java.util.*;

public class BinaryPalindromes {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder res = new StringBuilder();
		int t = reader.nextInt();
		while (t-- > 0) {
			int n = reader.nextInt();
			int[] ar = new int[n];
			int one = 0;
			int zero = 0;
			int count = 0;
			for (int i = 0; i < n; i++) {
				String s = reader.next();
				if ((s.length() & 1) == 1) {
					count++;
				}
				ar[i] = s.length();
				for (char j : s.toCharArray()) {
					if (j == '0') {
						zero++;
					} else {
						one++;
					}
				}
			}
			if (count == 0 && (one & 1) == 1 && (zero & 1) == 1) {
				res.append((n - 1) + "\n");
			} else {
				res.append(n + "\n");
			}
		}
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