package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Luhn {

	public void CheckCardNbrs() {

		String answer;
		Scanner inFile = null;
		String ccNumber = null;
		try {
			inFile = new Scanner(new FileReader("ccnbrs.txt"));

		} catch (FileNotFoundException e) {
			System.out.println();
			e.printStackTrace();
		}

		while (inFile.hasNext()) {
			ccNumber = inFile.next();

			int sum = 0;
			boolean doubleValue = false;

			for (int j = 0; j <= 9; j++) {
				sum = 0;
				for (int i = ccNumber.length() - 1; i >= 0; i--) {

					String current = ccNumber.substring(i, i + 1);
					int n;
					if (current.equals("X")) {

						n = j;
						if (doubleValue) {

							n *= 2;
							if (n > 9) {
								n -= 9;
							}
						}

					} else {
						n = Integer.parseInt(current);
						if (doubleValue) {
							n *= 2;
							if (n > 9) {
								n -= 9;
							}
						}

					}

					sum += n;
					doubleValue = !doubleValue;

				}

				if (sum % 10 == 0) {

					System.out.print(j);

				}
			}
		}
	}
}