import java.io.*;
import java.util.*;

public class ShiftStack {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		StringBuilder outBuffer = new StringBuilder();
		while (n-- > 0) {
			int length = reader.nextInt();
			int[] numbers = new int[length];
			for (int i = 0; i < length; i++) {
				numbers[i] = reader.nextInt();
			}
			long minNum = 0;
			long sum = 0;
			boolean possible = true;
			for (int i = 0; i < length; i++) {
				minNum += i;
				sum += numbers[i];
				if (sum < minNum) {
					possible = false;
					break;
				}
			}
			if (!possible)
				outBuffer.append("NO\n");
			else
				outBuffer.append("YES\n");
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