import java.io.*;
import java.util.*;

public class TwoTeamsComposing {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int t = reader.nextInt();
		StringBuilder outBuffer = new StringBuilder();
		while (t-- > 0) {
			int n = reader.nextInt();
			int[] skill = new int[n + 1];
			int distinctSize = 0;
			for (int i = 0; i < n; i++) {
				int temp = reader.nextInt();
				skill[temp]++;
				if (skill[temp] == 1)
					distinctSize++;
			}
			Arrays.sort(skill);
			int maxTime = skill[n];
			if (n < 2)
				outBuffer.append("0\n");
			else {

				if (distinctSize == maxTime) {
					int result = maxTime - 1;
					outBuffer.append(result + "\n");
				} else {
					int result = Math.min(distinctSize, maxTime);
					outBuffer.append(result + "\n");
				}
			}
		}
		System.out.print(outBuffer);
	}

	public static int last(int arr[], int low, int high, int x, int n) {
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if ((mid == n - 1 || x < arr[mid + 1]) && arr[mid] == x)
				return mid;
			else if (x < arr[mid])
				return last(arr, low, (mid - 1), x, n);
			else
				return last(arr, (mid + 1), high, x, n);
		}
		return -1;
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
