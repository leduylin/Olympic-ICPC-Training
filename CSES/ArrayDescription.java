package cses_5000;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class ArrayDescription {

	public static void main(String[] args) {
		int n = ni();
		int m = ni();
		int[] dp = new int[m + 1];
		int[] dq = new int[m + 1];
		for (int i = 0; i < n; i++) {
			int x = ni();
			if (i == 0) {
				if (x == 0)
					Arrays.fill(dq, 1);
				else {
					Arrays.fill(dq, 0);
					dq[x] = 1;
				}
			} else {
				if (x == 0)
					for (x = 1; x <= m; x++) {
						long z = dp[x];
						if (x > 1)
							z += dp[x - 1];
						if (x < m)
							z += dp[x + 1];
						dq[x] = (int) (z % 1000000007);
					}
				else {
					Arrays.fill(dq, 0);
					long z = dp[x];
					if (x > 1)
						z += dp[x - 1];
					if (x < m)
						z += dp[x + 1];
					dq[x] = (int) (z % 1000000007);
				}
			}
			int[] tmp = dp;
			dp = dq;
			dq = tmp;
		}
		long res = 0;
		for (int x = 1; x <= m; x++) {
			res += dp[x];
		}
		System.out.println(res % 1000000007);
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
