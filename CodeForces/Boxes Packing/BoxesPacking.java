import java.io.*;
import java.util.*;

public class BoxesPacking {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		int[] size = new int[n];
		for (int i = 0; i < n; i++) {
			size[i] = reader.nextInt();
		}
		Arrays.sort(size);
		int currentNum = Integer.MAX_VALUE;
		int count = 0;
		int countMax = 0;
		for (int i = 0; i < n; i++) {
			if (size[i] == currentNum)
				count++;
			else {
				currentNum = size[i];
				count = 1;
			}
			countMax = Math.max(countMax, count);
		}
		System.out.print(countMax);
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