package cses_5000;

import java.io.*;
import java.util.*;

public class Towers {

	public static void main(String[] args) {
		int n = ni();
		ArrayList<Integer> cubes = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			cubes.add(ni());
		}
		int res = minTowers(cubes, n);
		System.out.println(res);
	}

	static class Cube {
		int height;
		boolean checked = false;

		public Cube(int height) {
			super();
			this.height = height;
		}

	}

	public static int minTowers(ArrayList<Integer> arr, int n) {
		ArrayList<Integer> base = new ArrayList<>();

		for (int i = 0; i < n; ++i) {
			int z = arr.get(i);

			int low = 0, high = base.size();
			while (low < high) {
				int mid = (low + high) / 2;

				if (base.get(mid) > z) {
					high = mid;
				} else {
					low = mid + 1;
				}
			}
			if (low == base.size()) {

				// Create new tower.
				base.add(z);
			} else {

				// Add to min towers.
				base.set(low, z);
			}
		}

		return base.size();
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
