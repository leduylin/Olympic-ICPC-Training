package cses_5000;

import java.io.*;
import java.util.*;

public class ConcertTicketTrung {

	public static void main(String[] $) {
		int n = ni();
		int m = ni();
		int[] price = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			price[i] = ni();
		}
		Arrays.sort(price);
		pp = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			pp[i] = i;
		}
		StringBuilder outBuffer = new StringBuilder();
		while (m-- > 0) {
			int priceMax = ni();
			int lower = 0, upper = n + 1;
			while (upper - lower > 1) {
				int i = (lower + upper) / 2;
				if (price[i] <= priceMax)
					lower = i;
				else
					upper = i;
			}
			if (lower == 0) {
				outBuffer.append(-1 + "\n");
				continue;
			}
			int i = find(lower);
			if (i == 0) {
				outBuffer.append(-1 + "\n");
				continue;
			}
			outBuffer.append(price[i] + "\n");
			pp[i] = i - 1;
		}
		System.out.println(outBuffer);
	}

	static int[] pp;

	static int find(int i) {
		return pp[i] == i ? i : (pp[i] = find(pp[i]));
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
