package cses_5000;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class IncreasingSubsequence {

	static int[] temp;

	public static void main(String[] args) throws IOException {
		int n = ni();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = ni();
		}

		Integer[] index = new Integer[n];
		for (int i = 0; i < n; i++) {
			index[i] = i;
		}
		
		Arrays.sort(index, (i, j) -> numbers[i] != numbers[j] ? numbers[i] - numbers[j] : j - i);
		
		temp = new int[n];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int count = query(index[i]) + 1;
			ans = Math.max(ans, count);
			update(index[i], n, count);
		}
		System.out.println(ans);
	}

	static void update(int i, int n, int x) {
		while (i < n) {
			temp[i] = Math.max(temp[i], x);
			i |= i + 1;
		}
	}

	static int query(int i) {
		int ans = 0;
		while (i >= 0) {
			ans = Math.max(ans, temp[i]);
			i &= i + 1;
			i--;
		}
		return ans;
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
