import java.io.*;
import java.util.*;

public class MariaBreakstheSelfisolation {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		StringBuilder outBuffer = new StringBuilder();
		while (n-- > 0) {
			int length = reader.nextInt();
			int[] requireNum = new int[length];
			for (int i = 0; i < length; i++) {
				requireNum[i] = reader.nextInt();

			}
			Arrays.sort(requireNum);
			int maxExist = 1;
			for (int i = length - 1; i >= 0; i--) {
				if (requireNum[i] <= i + 1) {
					maxExist = i + 2;
					break;
				}
			}
			outBuffer.append(maxExist + "\n");
		}
		System.out.print(outBuffer);

	}

	static class Person {
		public int order;
		public int requireNum;
		public int quantity = 0;
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