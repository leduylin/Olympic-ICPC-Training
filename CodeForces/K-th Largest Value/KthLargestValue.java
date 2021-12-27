import java.io.*;
import java.util.*;

public class KthLargestValue {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt(), q = reader.nextInt();
		int[] number = new int[n];
		int[] count = new int[3];
		for (int i = 0; i < n; i++) {
			number[i] = reader.nextInt();
			count[number[i]]++;

		}
		StringBuilder outBuffer = new StringBuilder();

		for (int i = 0; i < q; i++) {
			int type = reader.nextInt();
			int xK = reader.nextInt();
			if (type == 1) {
				count[number[xK - 1]]--;
				number[xK - 1] = 1 - number[xK - 1];
				count[number[xK - 1]]++;
			} else {
				if (xK <= count[1])
					outBuffer.append(1 + "\n");
				else if (xK <= count[0] + count[1])
					outBuffer.append(0 + "\n");
				else
					outBuffer.append(-1 + "\n");
			}
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