import java.io.*;
import java.util.*;

public class FlagDay {

	public static void main(String args[]) {

		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		int m = reader.nextInt();
		int[] col = new int[n + 1];

		for (int i = 0; i < col.length; i++) {
			col[i] = -1;
		}

		int[] dancer = new int[3];
		for (int i = 0; i < m; i++) {

			boolean[] used = new boolean[3];
			for (int j = 0; j < 3; j++) {
				dancer[j] = reader.nextInt();
				if (col[dancer[j]] != -1) {
					used[col[dancer[j]]] = true;
				}
			}

			for (int j = 0; j < 3; j++) {
				if (col[dancer[j]] == -1) {
					int dress = 0;
					while (used[dress]) {
						dress = (dress + 1) % 3;
					}
					col[dancer[j]] = dress;
					used[dress] = true;
				}
			}
		}

		for (int i = 1; i < col.length; i++) {
			System.out.print((col[i] + 1) + " ");
		}
		System.out.println();
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