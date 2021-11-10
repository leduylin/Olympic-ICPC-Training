package cses_5000;

import java.io.*;
import java.util.*;

public class ConcertTickets {

	public static void main(String[] args) {
		int n = ni(), m = ni();
		List<Ticket> tickets = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			tickets.add(new Ticket(ni()));
		}
		tickets.sort((t1, t2) -> t1.price - t2.price);
		List<Integer> moneyMax = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			moneyMax.add(ni());
		}
		StringBuilder outBuffer = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int left = 0, right = n - 1;
			int center = left + (right - left) / 2;
			for (; left < right;) {
				if (moneyMax.get(i) < tickets.get(center).price)
					right = center;
				else if (moneyMax.get(i) > tickets.get(center).price)
					left = center;
				else
					break;
				center = left + (right - left) / 2;
			}
			if (tickets.get(center).available) {
				outBuffer.append(tickets.get(center).price + "\n");
				tickets.get(center).available = false;
			} else
				outBuffer.append("-1\n");

		}
		System.out.println(outBuffer);
	}

	static class Ticket {
		int price;
		int num = 0;
		boolean available = true;

		public Ticket(int price) {
			super();
			this.price = price;
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
