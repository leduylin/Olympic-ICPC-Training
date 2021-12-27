import java.io.*;
import java.util.*;

public class MUHandSticks {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int[] numbers = new int[6];
		for (int i = 0; i < 6; i++) {
			numbers[i] = reader.nextInt();
		}
		Arrays.sort(numbers);
		int countMax = 0;
		int length = numbers[0];
		int count = 1;
		int currentNum = numbers[0];
		for (int i = 1; i < 6; i++) {
			if (numbers[i] == currentNum) {
				count++;
				if (count > countMax) {
					countMax = count;
					length = numbers[i];
				}
			} else {
				count = 1;
				currentNum = numbers[i];
			}

		}
		if (countMax < 4)

		{
			System.out.print("Alien");
		} else {
			int delete = 0;
			for (int i = 0; i < 6; i++) {
				if (numbers[i] == length) {
					numbers[i] = 0;
					delete++;
				}
				if (delete == 4)
					break;
			}
			Arrays.sort(numbers);

			int firstNum = numbers[5];
			int secondNum = numbers[4];
			if (firstNum == secondNum)
				System.out.print("Elephant");
			else
				System.out.print("Bear");
		}
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
