package cses_5000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ConcertTicket3 {

	public static void main(String[] args) {
		InputReader sc = new InputReader(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		TreeMap<Integer, Integer> ticketPrices = new TreeMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			Integer price = sc.nextInt();
			Integer t = ticketPrices.get(price);
			if (t == null) {
				ticketPrices.put(price, 1);
			} else {
				ticketPrices.put(price, t + 1);
			}
		}
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < m; i++) {
			Integer cPrice = sc.nextInt();
			Integer ticket = ticketPrices.floorKey(cPrice);
			if (ticket == null) {
				res.append(-1 + "\n");
			} else {
				res.append(ticket);
				Integer t = ticketPrices.get(ticket + "\n");
				t--;
				if (t == 0) {
					ticketPrices.remove(ticket);
				} else {
					ticketPrices.put(ticket, t);
				}
			}
		}
		System.out.println(res);
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

	}

}
