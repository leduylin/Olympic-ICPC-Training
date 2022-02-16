import java.io.*;
import java.util.*;

public class InterestingDrink {

	public static void main(String[] args) {
		int n = ni();
		int[] prices = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = ni();
		}
		Arrays.sort(prices);
		findPrice(prices, n);
		System.out.println(outBuffer);

	}

	static StringBuilder outBuffer = new StringBuilder();

	static void findPrice(int prices[], int n) {
		int q = ni();
		while (q-- > 0) {
			int currentMoney = ni();
			if (currentMoney < prices[0]) {
				outBuffer.append(0 + "\n");
				continue;
			}
			int left = 0, right = n;
			int mid = 0;
			while (left < right) {
				mid = (left + right) / 2;
				if (prices[mid] > currentMoney)
					right = mid;
				else
					left = mid + 1;
			}
			outBuffer.append(left + "\n");
		}
	}

	static void usingBuiltInFunction(int[] prices) {
		int q = ni();
		while (q-- > 0) {
			int currentMoney = ni();
			int index = Arrays.binarySearch(prices, currentMoney);
			if (index < 0) {
				index = ~index;
				outBuffer.append(index + "\n");
			} else
				outBuffer.append((index + 1) + "\n");
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
