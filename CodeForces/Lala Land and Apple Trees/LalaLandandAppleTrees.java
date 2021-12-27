import java.io.*;
import java.util.*;

public class LalaLandandAppleTrees {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		List<Tree> right = new ArrayList<>();
		List<Tree> left = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int position = reader.nextInt();
			if (position > 0) {
				int appleNum = reader.nextInt();
				right.add(new Tree(position, appleNum));
			} else {
				int appleNum = reader.nextInt();
				left.add(new Tree(position, appleNum));
			}
		}

		Collections.sort(right, (right1, right2) -> {
			int compare = Integer.compare(right1.position, right2.position);
			return compare;
		});
		Collections.sort(left, (left1, left2) -> {
			int compare = Integer.compare(left2.position, left1.position);
			return compare;
		});

		int maxTurn = Math.min(right.size(), left.size());
		int maxApple = 0;

		for (int i = 0; i < maxTurn; i++) {
			maxApple += right.get(i).appleNum + left.get(i).appleNum;
		}

		if (right.size() > left.size())
			maxApple += right.get(maxTurn).appleNum;
		else if (right.size() < left.size())
			maxApple += left.get(maxTurn).appleNum;

		System.out.print(maxApple);

	}

	static class Tree {
		public int position;
		public int appleNum;

		public Tree(int position, int appleNum) {
			super();
			this.position = position;
			this.appleNum = appleNum;
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