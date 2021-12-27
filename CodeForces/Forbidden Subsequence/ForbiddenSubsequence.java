import java.io.*;
import java.util.*;

public class ForbiddenSubsequence {

	public static void main(String[] args) {
		int t = ni();
		StringBuilder outBuffer = new StringBuilder();
		while (t-- > 0) {
			String[] s = ns().split("");
			String abc = ns();
			Arrays.sort(s);
			if (!abc.equals("abc")) {
				for (String currentChar : s) {
					outBuffer.append(currentChar);
				}
			} else {
				boolean hasA = false;
				boolean hasB = false;
				boolean hasC = false;
				String temp = "";
				HashMap<String, Integer> charPosition = new HashMap<>();
				for (int i = 0; i < s.length; i++) {
					String currentChar = s[i];
					if (charPosition.get(currentChar) == null)
						charPosition.put(currentChar, i);
					temp += currentChar;
					if (currentChar.equals("a")) {
						hasA = true;
						continue;
					}
					if (currentChar.equals("b")) {
						hasB = true;
						continue;
					}
					if (currentChar.equals("c")) {
						hasC = true;
						continue;
					}
				}
				if (hasA && hasB && hasC) {
					int firstB = charPosition.get("b");
					int firstC = charPosition.get("c");
					for (int i = 0; i < firstB; i++) {
						outBuffer.append(s[i]);
					}
					int lastIndex = s.length;
					for (int i = firstC; i < s.length; i++) {
						if (s[i].compareTo("c") > 0) {
							lastIndex = i;
							break;
						}
						outBuffer.append(s[i]);
					}
					for (int i = firstB; i < firstC; i++) {
						outBuffer.append(s[i]);
					}
					for (int i = lastIndex; i < s.length; i++) {
						outBuffer.append(s[i]);
					}
				} else {
					outBuffer.append(temp);
				}
			}
			outBuffer.append("\n");
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