package cses_5000;

import java.io.*;
import java.util.*;

public class SumofTwoValues {

	public static void main(String[] args) {
		int n = ni(), x = ni();
		HashMap<Integer, Number> numberMap = new HashMap<>();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			int num = ni();
			numbers[i] = num;
			if (numberMap.get(num) == null) {
				Number newNum = new Number(num);
				newNum.addPosition(i + 1);
				numberMap.put(num, newNum);
			} else
				numberMap.get(num).addPosition(i + 1);

		}
		boolean possible = false;
		for (int i = 0; i < n; i++) {
			int numFound = x - numbers[i];
			if (numFound != numbers[i]) {
				if (numberMap.get(numFound) != null) {
					System.out.print(
							numberMap.get(numFound).position.get(0) + " " + numberMap.get(numbers[i]).position.get(0));
					possible = true;
					break;
				}
			} else {
				if (numberMap.get(numFound).position.size() >= 2) {
					System.out.print(
							numberMap.get(numFound).position.get(0) + " " + numberMap.get(numFound).position.get(1));
					possible = true;
					break;
				}
			}
		}
		if (!possible)
			System.out.print("IMPOSSIBLE");
	}

	static class Number {
		int num;
		List<Integer> position = new ArrayList<>();

		public Number(int num) {
			super();
			this.num = num;
		}

		public void addPosition(int x) {
			position.add(x);
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
