
import java.io.*;
import java.util.*;

public class PageNumbers {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		String input = reader.next();
		String[] pages = input.split(",");
		List<Integer> pagesNum = new ArrayList<>();
		for (int i = 0; i < pages.length; i++) {
			int temp = Integer.valueOf(pages[i]);
			if (!pagesNum.contains(temp))
				pagesNum.add(temp);
		}
		Collections.sort(pagesNum);
		StringBuilder outBuffer = new StringBuilder();
		int currentPage = pagesNum.get(0);
		int count = 0;
		for (int i = 0; i < pagesNum.size(); i++) {
			if (i == pagesNum.size() - 1) {
				if (pagesNum.get(pagesNum.size() - 1) == currentPage) {
					outBuffer.append(currentPage);
				} else
					outBuffer.append(currentPage + "-" + pagesNum.get(pagesNum.size() - 1));
				break;

			}
			if (pagesNum.get(i + 1) - pagesNum.get(i) == 1) {
				count++;
				continue;
			} else {
				if (count >= 1) {
					outBuffer.append(currentPage + "-" + pagesNum.get(i) + ",");
					count = 0;
					currentPage = pagesNum.get(i + 1);
				} else {
					outBuffer.append(currentPage + ",");
					count = 0;
					currentPage = pagesNum.get(i + 1);
				}
			}
		}
		System.out.print(outBuffer);

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