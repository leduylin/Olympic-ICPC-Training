import java.io.*;
import java.util.*;

public class Benches {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int numberOfBench = reader.nextInt();
		int peopleComing = reader.nextInt();
		int[] peopleEachBench = new int[numberOfBench];
		for (int i = 0; i < numberOfBench; i++) {
			peopleEachBench[i] = reader.nextInt();
		}
		Arrays.sort(peopleEachBench);
		int maxCurrent = peopleEachBench[numberOfBench - 1];
		int max = maxCurrent + peopleComing;
		boolean peopleLeft = true;
		for (int i = 0; i < numberOfBench - 1; i++) {
			peopleComing -= maxCurrent - peopleEachBench[i];
			if (peopleComing <= 0) {
				peopleLeft = false;
				break;
			}
		}
		int min = 0;
		if (peopleLeft)
			min = (int) (maxCurrent + Math.ceil((double) peopleComing / numberOfBench));
		else
			min = maxCurrent;

		System.out.print(min + " " + max);

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