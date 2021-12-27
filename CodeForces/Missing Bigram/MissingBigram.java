import java.io.*;
import java.util.*;

public class MissingBigram {

	public static void main(String[] args) {
		int t = ni();
		StringBuilder outBuffer = new StringBuilder();
		while (t-- > 0) {
			int n = ni();
			String[] pair = new String[n - 2];
			boolean hasA = false;
			boolean hasB = false;
			for (int i = 0; i < n - 2; i++) {
				pair[i] = ns();
				if (pair[i].charAt(0) == 'a' || pair[i].charAt(1) == 'a')
					hasA = true;
				if (pair[i].charAt(0) == 'b' || pair[i].charAt(1) == 'b')
					hasB = true;
			}
			if (n - 2 == 1) {
				if (!hasA)
					outBuffer.append(pair[0] + "a\n");
				else
					outBuffer.append(pair[0] + "b\n");

			} else {
				String finalString = pair[0];
				char lastChar = pair[0].charAt(1);
				boolean foundErase = false;
				for (int i = 1; i < n - 2; i++) {
					if (pair[i].charAt(0) == lastChar) {
						finalString += pair[i].charAt(1);
					} else {
						finalString += pair[i];
						foundErase = true;
					}
					lastChar = pair[i].charAt(1);
				}
				if (foundErase) {
					outBuffer.append(finalString + "\n");
				} else {
					if (!hasA)
						outBuffer.append("a" + finalString + "\n");
					else
						outBuffer.append("b" + finalString + "\n");

				}
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
