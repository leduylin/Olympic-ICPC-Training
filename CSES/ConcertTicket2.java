package cses_5000;

import java.io.*;
import java.util.*;

public class ConcertTicket2 {

	public static void main(String[] args) {
		int n = ni(), m = ni();
		int[] tickets = new int[n];
		for (int i = 0; i < n; i++) {
			tickets[i] = ni();
		}
		int[] moneyMax = new int[m];
		for (int i = 0; i < m; i++) {
			moneyMax[i] = ni();
		}

		int[] result = new int[m];
		result = getUserPrices(tickets, moneyMax);
		StringBuilder outBuffer = new StringBuilder();
		for (int i = 0; i < m; i++) {
			outBuffer.append(result[i] + "\n");
		}
		System.out.println(outBuffer);
	}

	private static int[] getUserPrices(int[] tickets, int[] moneyMax) {
		TreeMap<Integer, Integer> ticketTree = new TreeMap<>();
		for (int price : tickets) {
			if (ticketTree.get((price)) != null) {
				ticketTree.put(price, ticketTree.get(price) + 1);
			} else {
				ticketTree.put(price, 1);
			}
		}

		int[] result = new int[moneyMax.length];
		for (int i = 0; i < moneyMax.length; i++) {
			Integer priceChosen = ticketTree.floorKey(moneyMax[i]); // sau so sánh với null nên phải khai báo dạng object
			if (priceChosen != null) {
				result[i] = priceChosen;
				int quantity = ticketTree.get(priceChosen);
				if (quantity - 1 > 0) {
					ticketTree.put(priceChosen, quantity - 1);
				} else {
					ticketTree.remove(priceChosen);
				}
			} else {
				result[i] = -1;
			}
		}

		return result;
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
