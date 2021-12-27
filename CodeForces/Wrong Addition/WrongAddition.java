import java.io.*;
import java.util.*;

public class WrongAddition {

	public static void main(String[] args) {
		int t = ni();
		StringBuilder outBuffer = new StringBuilder();
		while (t-- > 0) {
			char[] firstNum = ns().toCharArray();
			char[] res = ns().toCharArray();
			int[] a = new int[firstNum.length];
			int[] s = new int[res.length];
			for (int i = 0; i < a.length; i++) {
				a[i] = Integer.valueOf(firstNum[i] + "");
			}
			for (int i = 0; i < s.length; i++) {
				s[i] = Integer.valueOf(res[i] + "");
			}
			List<Integer> bSplit = new ArrayList<>();
			boolean canFind = true;
			int i = a.length - 1, j = s.length - 1;
			for (; i >= 0 && j >= 0;) {
				if (a[i] <= s[j]) {
					bSplit.add(s[j] - a[i]);
				} else {
					j--;
					if (j < 0) {
						canFind = false;
						break;
					}
					int temp = s[j] * 10 + s[j + 1] - a[i];
					if (temp >= 10 || temp < 0) {
						canFind = false;
						break;
					}
					bSplit.add(temp);
				}
				i--;
				j--;
			}
			if (i >= 0 || !canFind) {
				outBuffer.append("-1");
			} else {
				if (j >= 0) {
					for (; j >= 0; j--) {
						bSplit.add(s[j]);
					}
				}
				int k = bSplit.size() - 1;
				for (; k >= 0; k--) {
					if (bSplit.get(k) > 0)
						break;
				}
				for (; k >= 0; k--) {
					outBuffer.append(bSplit.get(k));
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