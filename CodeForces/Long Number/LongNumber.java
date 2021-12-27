
import java.io.*;
import java.util.*;

public class LongNumber {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		String number = reader.next();
		String[] numberSplit = number.split("");
		int[] num = new int[n];
		int[] changedValue = new int[10];
		for (int i = 1; i < 10; i++) {
			changedValue[i] = reader.nextInt();
		}
		boolean change = false;
		boolean read = false;
		for (int i = 0; i < n; i++) {
			num[i] = Integer.valueOf(numberSplit[i]);
			if (!read) {
				if (changedValue[num[i]] > num[i]) {
					num[i] = changedValue[num[i]];
					change = true;
				} else if (changedValue[num[i]] < num[i] && change)
					read = true;
			}
		}
		StringBuilder outBuffer = new StringBuilder();
		for (int i = 0; i < n; i++) {
			outBuffer.append(num[i]);
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