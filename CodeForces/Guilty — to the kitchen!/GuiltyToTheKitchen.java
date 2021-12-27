import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class GuiltyToTheKitchen {

	public static void main(String[] args) {
		int n = ni(), V = ni();
		notUsingDataStructure(n, V);
	}

	static DecimalFormat df = new DecimalFormat("####0.0###");

	static void notUsingDataStructure(int n, int V) {
		int sum = 0;
		int[] percent = new int[n];
		for (int i = 0; i < n; i++) {
			sum += percent[i] = ni();
		}
		double rateMin = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			rateMin = Math.min(rateMin, (double) ni() / percent[i]);
		}
		double res = rateMin * sum;
		if (res > V)
			res = V;
		System.out.println(df.format(res));

	}

	static void usingDataStructure(int n, int V) {
		int sum = 0;
		Ingredient[] ingredients = new Ingredient[n];
		for (int i = 0; i < n; i++) {
			int percent = ni();
			sum += percent;
			ingredients[i] = new Ingredient(percent);
		}
		double rateMin = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			ingredients[i].addLiter(ni());
			rateMin = Math.min(rateMin, ingredients[i].rate);
		}
		double res = rateMin * sum;
		if (res > V)
			res = V;
		System.out.println(df.format(res));
	}

	static class Ingredient {
		int percent;
		int litersHaving;
		double rate;

		public Ingredient(int percent) {
			super();
			this.percent = percent;
		}

		public void addLiter(int t) {
			this.litersHaving = t;
			rate = (double) litersHaving / percent;
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