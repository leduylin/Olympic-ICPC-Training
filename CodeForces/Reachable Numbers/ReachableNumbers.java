import java.io.*;
import java.util.*;

public class ReachableNumbers {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		boolean repeat = false;
		List<Integer> num = new ArrayList<>();
		num.add(n);
		int count = 1;
		while (!repeat) {
			n++;
			String number = String.valueOf(n);
			for (int i = number.length() - 1; i >= 0; i--) {
				String current = number.charAt(i) + "";
				if (current.equals("0"))
					n = n / 10;
				else {
					if (!num.contains(n)) {
						num.add(n);
						count++;
					} else
						repeat = true;
					break;
				}
			}
		}
		System.out.print(count);
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