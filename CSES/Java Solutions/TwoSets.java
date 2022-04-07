package cses_5000;

import java.io.*;
import java.util.*;

public class TwoSets {

	public static void main(String[] args) {
		int n = ni();
		// long sum = n * (n + 1) / 2;
		long sum = 0;
		for (int i = 0; i <= n; i++) {
			sum += i;
		}
		if (sum % 2 != 0) {
			System.out.print("NO");
		} else {
			long halfSum = sum / 2;
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();

			for (int i = n; i > 0; i--) {
				if (i <= halfSum) {
					list1.add(i);
					halfSum -= i;
				} else
					list2.add(i);
			}
			StringBuilder outBuffer = new StringBuilder();
			outBuffer.append("YES\n");
			outBuffer.append(list1.size() + "\n");
			for (int i = 0; i < list1.size(); i++) {
				outBuffer.append(list1.get(i) + " ");
			}
			outBuffer.append("\n" + list2.size() + "\n");
			for (int i = 0; i < list2.size(); i++) {
				outBuffer.append(list2.get(i) + " ");
			}

			System.out.println(outBuffer);
		}
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
