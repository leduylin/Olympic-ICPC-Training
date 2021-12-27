package CodeForces;

import java.io.*;
import java.util.*;

public class FoxAndCross_1100 {

	public static void main(String[] args) {
		int n = ni();
		String[][] board = new String[n][n];
		for (int i = 0; i < n; i++) {
			board[i] = ns().split("");
		}
		// current position: (i,j)
		// check (i+1,j-1),(i+1,j),(i+1,j+1),(i+2,j)
		boolean canDraw = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j].equals("#")) {
					if ((i + 1) <= n && (j - 1) >= 0 && (j + 1) <= n && (i + 2) <= n) {
						if (board[i + 1][j - 1].equals("#") && board[i + 1][j].equals("#")
								&& board[i + 1][j + 1].equals("#") && board[i + 2][j].equals("#")) {
							board[i + 1][j - 1] = ".";
							board[i + 1][j] = ".";
							board[i + 1][j + 1] = ".";
							board[i + 2][j] = ".";
						} else {
							canDraw = false;
							break;
						}
					} else {
						canDraw = false;
						break;
					}
				}
			}
			if (!canDraw)
				break;
		}
		if (canDraw)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	static InputStream is = System.in;

	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static float nf() {
		return Float.parseFloat(ns());
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static int ni() {
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

	static long nl() {
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
