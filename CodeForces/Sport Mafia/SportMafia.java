import java.io.*;
import java.util.*;

public class SportMafia {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int numberOfAction = reader.nextInt();
		int candyLeft = reader.nextInt();
		int candyHaving = 0;
		for (int i = 1; i < numberOfAction + 1; i++) {
			candyHaving += i;
			int candyAte = candyHaving - candyLeft;
			int turnLeft = numberOfAction - i;
			if (candyHaving > candyLeft && candyAte == turnLeft)
				break;
		}
		int result = candyHaving - candyLeft;
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