import java.io.*;
import java.util.*;

public class AandBandCompilationErrors {

	public static void main(String[] args) {
		//usingSort();
		Sum();
	}

	static InputReader reader = new InputReader(System.in);

	static void Sum() {
		int n = reader.nextInt();
		long firstSum = 0, secondSum = 0, thirdSum = 0;

		for (int i = 0; i < n; i++) {
			firstSum += reader.nextInt();
		}

		for (int i = 0; i < n - 1; i++) {
			secondSum += reader.nextInt();
		}

		for (int i = 0; i < n - 2; i++) {
			thirdSum += reader.nextInt();
		}
		System.out.println((firstSum - secondSum) + "\n" + (secondSum - thirdSum));
	}

	static void usingSort() {
		int n = reader.nextInt();
		int[] original = new int[n];
		for (int i = 0; i < n; i++) {
			original[i] = reader.nextInt();
		}
		Arrays.sort(original);

		int[] firstCorrection = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			firstCorrection[i] = reader.nextInt();
		}
		Arrays.sort(firstCorrection);

		int firstE = -1;
		for (int i = 0; i < n - 1; i++) {
			if (original[i] != firstCorrection[i]) {
				firstE = original[i];
				break;
			}
		}
		if (firstE == -1)
			firstE = original[n - 1];

		int[] secondCorrection = new int[n - 2];
		for (int i = 0; i < n - 2; i++) {
			secondCorrection[i] = reader.nextInt();
		}
		Arrays.sort(secondCorrection);

		int secondE = -1;
		for (int i = 0; i < n - 2; i++) {
			if (secondCorrection[i] != firstCorrection[i]) {
				secondE = firstCorrection[i];
				break;
			}
		}
		if (secondE == -1)
			secondE = firstCorrection[n - 2];

		System.out.println(firstE + "\n" + secondE);
	}

	static void usingSetandMap() {
		int n = reader.nextInt();
		Set<Integer> errorSet = new HashSet<>();
		Map<Integer, Integer> totalErrorMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int current = reader.nextInt();
			errorSet.add(current);
			if (totalErrorMap.get(current) == null)
				totalErrorMap.put(current, 1);
			else
				totalErrorMap.put(current, totalErrorMap.get(current) + 1);
		}

		Map<Integer, Integer> firstTurnCorrect = new HashMap<>();
		for (int i = 0; i < n - 1; i++) {
			int current = reader.nextInt();
			if (firstTurnCorrect.get(current) == null)
				firstTurnCorrect.put(current, 1);
			else
				firstTurnCorrect.put(current, firstTurnCorrect.get(current) + 1);
		}
		int firstE = 0;
		for (int x : errorSet) {
			Integer count = firstTurnCorrect.get(x);
			if (count == null || totalErrorMap.get(x) > count) {
				firstE = x;
				break;
			}
		}
		Map<Integer, Integer> secondTurnCorrect = new HashMap<>();
		for (int i = 0; i < n - 2; i++) {
			int current = reader.nextInt();
			if (secondTurnCorrect.get(current) == null)
				secondTurnCorrect.put(current, 1);
			else
				secondTurnCorrect.put(current, secondTurnCorrect.get(current) + 1);
		}
		int secondE = 0;
		for (int x : errorSet) {
			if (firstTurnCorrect.get(x) == null)
				continue;
			Integer count = secondTurnCorrect.get(x);
			if (count == null || firstTurnCorrect.get(x) > count) {
				secondE = x;
				break;
			}
		}

		System.out.println(firstE + "\n" + secondE);

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
