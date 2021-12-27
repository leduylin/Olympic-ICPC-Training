import java.io.*;
import java.util.*;

public class GameWithString {

	public static void main(String[] args) {
		String givenString = ns();
		usingStack(givenString);
	}
	public void usingStringMethod(String givenString) {
		int count = 0;
		for (int i = 0; i < givenString.length() - 1; i++) {
			if (givenString.charAt(i) == givenString.charAt(i + 1)) {
				count++;
				String before = givenString.substring(0, i), after = givenString.substring(i + 2, givenString.length());
				givenString = before + after;
				i = i - 2;
				if (i < 0)
					i = -1;
			}
		}
		if (count % 2 == 0)
			System.out.println("No");
		else
			System.out.println("Yes");
	}
	 public static void usingStack(String givenString) {
		 String[] charArray = givenString.split("");
		 Stack<String> charStack = new Stack<>();
		 int count = 0;
		 for(String currentChar : charArray) {
			 if(charStack.empty()||!charStack.peek().equals(currentChar)) {
				 charStack.push(currentChar);
			 }else if(charStack.peek().equals(currentChar)) {
				 charStack.pop();
				 count++;
			 }
		 }
		 if (count % 2 == 0)
				System.out.println("No");
			else
				System.out.println("Yes");
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
