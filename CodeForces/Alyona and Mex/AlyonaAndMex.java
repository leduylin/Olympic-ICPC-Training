import java.io.*;
import java.util.*;

public class AlyonaAndMex {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int length = reader.nextInt();
		Integer[] numbers = new Integer[length];
		for (int i = 0; i < length; i++) {
			numbers[i] = reader.nextInt();
		}
		Arrays.sort(numbers);
		numbers[0] = 1;
		for (int i = 0; i < length - 1; i++) {
			if (numbers[i + 1] - numbers[i] > 1)
				numbers[i + 1] = numbers[i] + 1;
		}
		long result = numbers[length - 1] + 1;
		System.out.print(result);
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