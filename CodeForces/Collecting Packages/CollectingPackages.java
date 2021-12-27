import java.io.*;
import java.util.*;

public class CollectingPackages {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int n = reader.nextInt();
		StringBuilder outBuffer = new StringBuilder();
		while (n-- > 0) {
			int numberOfPresent = reader.nextInt();
			Point[] points = new Point[numberOfPresent];
			for (int i = 0; i < numberOfPresent; i++) {
				points[i] = new Point(reader.nextInt(), reader.nextInt());
			}
			Arrays.sort(points, (point1, point2) -> {
				int compare = Integer.compare(point1.y, point2.y);
				if (compare != 0)
					return compare;
				compare = Integer.compare(point1.x, point2.x);
				return compare;
			});
			int lastX = 0;
			int lastY = 0;
			boolean possible = true;
			String result = "";
			for (int i = 0; i < numberOfPresent; i++) {
				if (points[i].y == lastY) {
					int temp = points[i].x - lastX;
					for (int j = 0; j < temp; j++) {
						result += "R";
					}
					lastX = points[i].x;
				} else {
					if (points[i].x < lastX) {
						possible = false;
						break;
					}
					int temp1 = points[i].x - lastX;
					for (int j = 0; j < temp1; j++) {
						result += "R";
					}
					int temp2 = points[i].y - lastY;
					for (int j = 0; j < temp2; j++) {
						result += "U";
					}
					lastY = points[i].y;
					lastX = points[i].x;
				}
			}
			if (!possible)
				outBuffer.append("NO\n");
			else
				outBuffer.append("YES\n" + result + "\n");
		}
		System.out.print(outBuffer);
	}

	static class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
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