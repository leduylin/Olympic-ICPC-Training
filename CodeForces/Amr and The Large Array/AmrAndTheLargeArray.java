import java.io.*;
import java.util.*;

public class AmrAndTheLargeArray {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		int[] numbers = new int[1000001];
		int[] firstPosition = new int[1000001];
		int maxI = 0, minI = 0, firstExist = -1;
		for (int i = 0; i < n; i++) {
			int temp = reader.nextInt();
			if (numbers[temp] == 0) {
				numbers[temp] = 1;
				firstPosition[temp] = i;
			} else
				numbers[temp]++;

			if (numbers[temp] > maxI) {
				maxI = numbers[temp];
				minI = i - firstPosition[temp];
				firstExist = firstPosition[temp] + 1;
			} else if (numbers[temp] == maxI && minI > (i - firstPosition[temp])) {
				minI = i - firstPosition[temp];
				firstExist = firstPosition[temp] + 1;
			}

		}
		int last = firstExist + minI;
		System.out.print(firstExist + " " + last);

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