import java.io.*;
import java.util.*;

public class CorrectSolution {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		String number = reader.next();
		String answerNum = reader.next();
		Integer[] num = new Integer[number.length()];
		for (int i = 0; i < number.length(); i++) {
			num[i] = Integer.valueOf(number.charAt(i) + "");
		}
		Arrays.sort(num);
		for (int i = 0; i < number.length(); i++) {
			if (num[i] != 0) {
				int temp = num[i];
				num[i] = num[0];
				num[0] = temp;
				break;
			}
		}
		String output = "";
		for (int i = 0; i < number.length(); i++) {
			output += num[i];
		}
		if (output.equals(answerNum))
			System.out.print("OK");
		else
			System.out.print("WRONG_ANSWER");

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