import java.io.*;
import java.util.*;

public class YaroslavAndPermutations {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = reader.nextInt();
		}
		Arrays.sort(numbers);
		int limit = (int) Math.ceil((double) n / 2);
		int countMax = 0;
		int count = 1;
		int currentNum = numbers[0];
		for (int i = 1; i < n; i++) {
			if (numbers[i] == currentNum) {
				count++;
				countMax = Math.max(countMax, count);
			} else {
				currentNum = numbers[i];
				count = 1;
			}
		}
		if (countMax <= limit)
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