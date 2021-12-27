import java.io.*;
import java.util.*;

public class TeamOlympiad {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		int[] subject = new int[3];
		List<Integer> one = new ArrayList<>();
		List<Integer> two = new ArrayList<>();
		List<Integer> three = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int temp = reader.nextInt();
			subject[temp - 1]++;
			if (temp == 1)
				one.add(i + 1);
			else if (temp == 2)
				two.add(i + 1);
			else
				three.add(i + 1);
		}
		Arrays.sort(subject);
		int result = subject[0];
		StringBuilder outBuffer = new StringBuilder();
		outBuffer.append(result + "\n");
		for (int i = 0; i < result; i++) {
			outBuffer.append(one.get(0) + " " + two.get(0) + " " + three.get(0) + "\n");
			one.remove(0);
			two.remove(0);
			three.remove(0);
		}
		System.out.print(outBuffer);

	}

	static class Person {
		public int order;
		public int subject;

		public Person(int order, int subject) {
			super();
			this.order = order;
			this.subject = subject;
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
