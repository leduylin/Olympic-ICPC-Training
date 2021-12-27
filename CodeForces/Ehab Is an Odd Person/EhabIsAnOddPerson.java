import java.io.*;
import java.util.*;

public class EhabIsAnOddPerson {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		Integer[] number = new Integer[n];
		boolean odd = false, even = false;
		for (int i = 0; i < n; i++) {
			number[i] = reader.nextInt();
			if (number[i] % 2 == 1)
				odd = true;
			else
				even = true;
		}
		if (odd && even)
			Arrays.sort(number);

		StringBuilder outBuffer = new StringBuilder();
		for (int i = 0; i < n; i++) {
			outBuffer.append(number[i] + " ");
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