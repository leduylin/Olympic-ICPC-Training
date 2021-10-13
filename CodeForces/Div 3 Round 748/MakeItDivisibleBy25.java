package CodeForces;

import java.io.*;
import java.util.*;

public class MakeItDivisibleBy25 {

	public static void main(String[] args) {
		int n = ni();
		StringBuilder outBuffer = new StringBuilder();
		while (n-- > 0) {
			long num = nl();
			if (num % 25 == 0) {
				outBuffer.append(0 + "\n");
			} else {
				String numTypeString = String.valueOf(num);
				int[] numSplit = new int[numTypeString.length()];
				for (int i = 0; i < numSplit.length; i++) {
					numSplit[i] = Integer.valueOf(numTypeString.charAt(i) + "");
				}

				int minTurn = Integer.MAX_VALUE;
				int count = 0;
				for (int i = 0; i < numSplit.length - 1; i++) {
					for (int j = i + 1; j < numSplit.length; j++) {
						int currentNum = numSplit[i] * 10 + numSplit[j];
						if (currentNum % 25 == 0) {
							count = (j - i - 1) + (numSplit.length - 1 - j);
							minTurn = Math.min(minTurn, count);
						}
					}
				}
				outBuffer.append(minTurn + "\n");
			}
		}
		System.out.println(outBuffer);
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
