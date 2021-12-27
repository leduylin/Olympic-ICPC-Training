import java.io.*;
import java.util.*;

public class KirillAndTheGame {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int l = reader.nextInt();
		int r = reader.nextInt();
		int x = reader.nextInt();
		int y = reader.nextInt();
		double k = reader.nextDouble();
		boolean possible = false;
		for (int i = x; i <= y; i++) {
			double temp = i * k;
			if (temp >= l && temp <= r) {
				possible = true;
				break;
			}
		}
		if (possible)
			System.out.print("YES");
		else
			System.out.print("NO");

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