
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class PotionsHomework {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		int[] tasks = new int[n];
		for (int i = 0; i < n; i++) {
			tasks[i] = reader.nextInt();
		}
		Arrays.sort(tasks);
		BigInteger minTime = BigInteger.valueOf(0);
		for (int i = 0; i < n; i++) {
			BigInteger multi = BigInteger.valueOf(tasks[i]).multiply(BigInteger.valueOf(tasks[n - i - 1]));
			minTime = minTime.add(multi);
		}
		minTime = minTime.mod(BigInteger.valueOf(10007));
		System.out.print(minTime);
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