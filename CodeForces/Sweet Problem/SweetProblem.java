import java.io.*;
import java.util.*;

public class SweetProblem {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		StringBuilder outBuffer = new StringBuilder();
		while (n-- > 0) {
			int[] candy = new int[3];
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				candy[i] = reader.nextInt();
				sum += candy[i];
			}
			Arrays.sort(candy);
			int maxTurn = 0;
			if (candy[2] <= candy[1] + candy[0])
				maxTurn = Math.floorDiv(sum, 2);
			else
				maxTurn = candy[1] + candy[0];
			outBuffer.append(maxTurn + "\n");
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