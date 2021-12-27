import java.io.*;
import java.util.*;

public class NewBusRoute {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		Integer[] numbers = new Integer[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = reader.nextInt();
		}
		Arrays.sort(numbers);
		int minDistance = Integer.MAX_VALUE;
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			long distance = Math.abs(numbers[i] - numbers[i + 1]);
			if (distance < minDistance) {
				minDistance = (int) distance;
				count = 1;
			} else if (distance == minDistance)
				count++;
		}
		System.out.print(minDistance + " " + count);
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