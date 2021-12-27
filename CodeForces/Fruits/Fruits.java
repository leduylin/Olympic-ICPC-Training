import java.io.*;
import java.util.*;

public class Fruits {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int numberOfPriceTag = reader.nextInt();
		int numberOfFruit = reader.nextInt();
		int[] price = new int[numberOfPriceTag];
		for (int i = 0; i < numberOfPriceTag; i++) {
			price[i] = reader.nextInt();
		}
		HashMap<String, Integer> fruit = new HashMap<>();
		for (int i = 0; i < numberOfFruit; i++) {
			String name = reader.next();
			if (fruit.containsKey(name))
				fruit.replace(name, fruit.get(name) + 1);
			else
				fruit.put(name, 1);
		}
		int i = 0;
		Fruit[] fruits = new Fruit[fruit.size()];
		for (Map.Entry<String, Integer> e : fruit.entrySet()) {
			fruits[i] = new Fruit();
			int value = e.getValue();
			fruits[i].quantity = e.getValue();
			i++;
		}

		Arrays.sort(price);
		Arrays.sort(fruits, (fruit1, fruit2) -> {
			int compare = Integer.compare(fruit2.quantity, fruit1.quantity);
			return compare;
		});

		int minPrice = 0;
		int maxPrice = 0;
		for (int j = 0; j < fruits.length; j++) {
			minPrice += fruits[j].quantity * price[j];
		}
		for (int j = 0, k = numberOfPriceTag - 1; j < fruits.length; j++, k--) {
			maxPrice += fruits[j].quantity * price[k];
		}
		System.out.print(minPrice + " " + maxPrice);

	}

	static class Fruit {
		public int quantity;
	}

	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}

}