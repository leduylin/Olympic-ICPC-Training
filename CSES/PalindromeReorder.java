package cses_5000;

import java.io.*;
import java.util.*;

public class PalindromeReorder {

	public static void main(String[] args) {
		String stringGiven = ns();
		String[] stringSplit = stringGiven.split("");
		List<Letter> letters = new ArrayList<>();
		HashMap<String, Letter> lettersMap = new HashMap<>();
		for (int i = 0; i < stringSplit.length; i++) {
			if (lettersMap.get(stringSplit[i]) == null) {
				Letter newLetter = new Letter(stringSplit[i]);
				lettersMap.put(stringSplit[i], newLetter);
				letters.add(newLetter);
				lettersMap.get(stringSplit[i]).IncreaseQuantity();
			} else
				lettersMap.get(stringSplit[i]).IncreaseQuantity();
		}

		boolean isPalindrome = true;
		int limit = 0;
		if (stringGiven.length() % 2 != 0)
			limit = 1;
		int count = 0;
		Letter oddQuantityLetter = null;
		for (int i = 0; i < letters.size(); i++) {
			if (letters.get(i).count % 2 != 0) {
				count++;
				oddQuantityLetter = letters.get(i);
			}
			if (count > limit) {
				isPalindrome = false;
				break;
			}
		}

		if (isPalindrome) {
			String[] finalString = new String[stringGiven.length()];
			if (limit == 1) {
				int centerPosition = stringGiven.length() / 2;
				finalString[centerPosition] = oddQuantityLetter.letter;
				oddQuantityLetter.count--;
			}
			for (int i = 0, j = 0; i < stringGiven.length() / 2; i++) {
				if (letters.get(j).count == 0)
					j++;
				finalString[i] = letters.get(j).letter;
				finalString[stringGiven.length() - 1 - i] = letters.get(j).letter;
				letters.get(j).count -= 2;
			}
			StringBuilder outBuffer = new StringBuilder();
			for (int i = 0; i < finalString.length; i++) {
				outBuffer.append(finalString[i]);
			}
			System.out.print(outBuffer);
		} else {
			System.out.print("NO SOLUTION");
		}

	}

	static class Letter {
		public String letter;
		public int count;

		public Letter(String letter) {
			super();
			this.letter = letter;
		}

		public void IncreaseQuantity() {
			this.count++;
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
