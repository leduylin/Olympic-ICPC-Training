import java.io.*;
import java.util.*;

public class CircleOfMonsters {

	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader(System.in);
		int t = reader.nextInt();
		StringBuilder res = new StringBuilder();
		while (t-- > 0) {
			int n = reader.nextInt();

			long shots = 0;
			long firstHealth = reader.nextLong();
			long firstDamage = reader.nextLong();
			long lastDamage = firstDamage;
			long minHealth = firstHealth;

			for (int i = 1; i < n; i++) {
				long currentHealth = reader.nextLong();
				long currentDamage = reader.nextLong();
				if (lastDamage < currentHealth) {
					shots += currentHealth - lastDamage;
					currentHealth = lastDamage;
				}
				minHealth = Math.min(minHealth, currentHealth);
				lastDamage = currentDamage;
			}

			if (lastDamage < firstHealth) {
				shots += firstHealth - lastDamage;
				firstHealth = lastDamage;
			}

			minHealth = Math.min(minHealth, firstHealth);

			res.append((minHealth + shots) + "\n");
		}
		System.out.println(res);

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