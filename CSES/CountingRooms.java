package cses_5000;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class CountingRooms {

	static int n;
	static int m;
	static char[][] map = new char[1000][1000];

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		n = reader.nextInt();
		m = reader.nextInt();
		for (int i = 0; i < n; i++) {
			map[i] = reader.next().toCharArray();

		}
		int countRoom = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '.') {
					countRoom++;
					DFS(i, j);
				}
			}
		}

		System.out.println(countRoom);
	}

	static boolean Validate(int i, int j) {
		boolean vertical = i >= 0 && i < map.length;
		boolean horizontal = false;
		if (vertical) {
			horizontal = j >= 0 && j < map[i].length;
		}
		return vertical && horizontal && map[i][j] == '.';
	}

	static void DFS(int i, int j) {
		map[i][j] = '#';
		// up
		if (Validate(i - 1, j)) {
			DFS(i - 1, j);
		}
		// down
		if (Validate(i + 1, j)) {
			DFS(i + 1, j);
		}
		// left
		if (Validate(i, j - 1)) {
			DFS(i, j - 1);
		}
		// right
		if (Validate(i, j + 1)) {
			DFS(i, j + 1);
		}
	}

	static class InputReader {
		public int bufferLength = 0, bufferPointer = 0;
		public InputStream is;
		private byte[] inputBuffer = new byte[1 << 20];

		public InputReader(InputStream stream) {
			try {
				inputBuffer = new byte[2 << 23];
				bufferLength = 0;
				bufferPointer = 0;
				is = stream;
				bufferLength = is.read(inputBuffer);
			} catch (Exception ignored) {
			}
		}

		public boolean hasNext() throws IOException {
			if (skip() >= 0) {
				bufferPointer--;
				return true;
			}
			return false;
		}

		public String nextLine() throws IOException {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while (!isSpaceChar(b) && b != ' ') { // when nextLine, ()
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		public String next() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		private int readByte() {
			if (bufferLength == -1)
				throw new InputMismatchException();
			if (bufferPointer >= bufferLength) {
				return -1;
			}
			return inputBuffer[bufferPointer++];
		}

		private boolean isSpaceChar(int c) {
			return !(c >= 33 && c <= 126);
		}

		private double nextDouble() {
			return Double.parseDouble(next());
		}

		public Character nextChar() {
			return skip() >= 0 ? (char) skip() : null;
		}

		private int skip() {
			int b;
			while ((b = readByte()) != -1 && isSpaceChar(b))
				;
			return b;
		}

		public int nextInt() {
			int num = 0, b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}

			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

		public long nextLong() {
			long num = 0;
			int b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}

			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}
	}
}