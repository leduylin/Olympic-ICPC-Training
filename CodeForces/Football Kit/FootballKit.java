import java.io.*;
import java.util.*;

public class FootballKit {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		FootballTeam[] teams = new FootballTeam[n];
		int[] x = new int[100001];
		int[] y = new int[100001];
		for (int i = 0; i < n; i++) {
			int xTemp = reader.nextInt();
			int yTemp = reader.nextInt();
			teams[i] = new FootballTeam(xTemp, yTemp);
			x[xTemp]++;
			y[yTemp]++;
		}
		for (int i = 0; i < n; i++) {
			teams[i].countHome = n - 1;
			teams[i].countHome += x[teams[i].awayColor];
			teams[i].countAway = 2 * (n - 1) - teams[i].countHome;
		}
		StringBuilder outBuffer = new StringBuilder();
		for (int i = 0; i < n; i++) {
			outBuffer.append(teams[i].countHome + " " + teams[i].countAway + "\n");
		}
		System.out.print(outBuffer);
	}

	static class FootballTeam {
		public int homeColor;
		public int awayColor;
		public int countHome = 0;
		public int countAway = 0;

		public FootballTeam(int homeColor, int awayColor) {
			super();
			this.homeColor = homeColor;
			this.awayColor = awayColor;
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