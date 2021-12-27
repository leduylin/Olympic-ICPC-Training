import java.io.*;
import java.util.*;

public class LessOrEqual {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		int k = reader.nextInt();
		Integer[] numbers = new Integer[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = reader.nextInt();
		}
		Arrays.sort(numbers);
		long result = 0;

		if (k == 0) {
			if (numbers[0] - 1 > 0)
				System.out.print(numbers[0] - 1);
			else
				System.out.print("-1");
		} else if (k < n) {
			if (numbers[k] - numbers[k - 1] >= 1)
				System.out.print(numbers[k - 1]);
			else
				System.out.print("-1");
		} else {
			result = numbers[k - 1];
			System.out.print(result);
		}

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
