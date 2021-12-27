import java.io.*;
import java.util.*;

public class MicroWorld {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		int k = reader.nextInt();
		TreeSet<Integer> tree = new TreeSet<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int a = reader.nextInt();
			tree.add(a);
			list.add(a);
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			Integer z = tree.higher(list.get(i));
			if (z == null || z - k > list.get(i)) {
				count++;
			}
		}
		System.out.println(count);
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