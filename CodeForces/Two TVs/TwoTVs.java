import java.io.*;
import java.util.*;

public class TwoTVs {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		Show[] shows = new Show[n];
		for (int i = 0; i < n; i++) {
			shows[i] = new Show(reader.nextInt(), reader.nextInt());
		}
		Arrays.sort(shows, (show1, show2) -> {
			int compare = Integer.compare(show1.start, show2.start);
			if (compare != 0)
				return compare;
			compare = Integer.compare(show1.end, show2.end);
			return 0;
		});
		boolean possible = true;
		int end1 = -1;
		int end2 = -1;
		for (int i = 0; i < n; i++) {
			if (end1 >= shows[i].start && end2 >= shows[i].start) {
				possible = false;
				break;
			}
			if (end1 < shows[i].start)
				end1 = shows[i].end;
			else if (end2 < shows[i].start)
				end2 = shows[i].end;

		}
		if (possible)
			System.out.print("YES");
		else
			System.out.print("NO");
	}

	static class Show {
		public int start;
		public int end;

		public Show(int start, int end) {
			super();
			this.start = start;
			this.end = end;
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