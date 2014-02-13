package main.java;

import java.util.*;
import java.io.*;

public class FooBarBaz {

	final String foo = "Foo";
	final String bar = "Bar";
	final String baz = "Baz";
	FileWriter fw;
	int n;

	public static void main(String args[]) throws Exception {

		FooBarBaz obj = new FooBarBaz();
		obj.n = obj.readInput();
		obj.fooBarBazInput(obj.n);

	}

	// Method to write some text content on to a file.
	public void writeFile(String input) throws Exception {
		fw = new FileWriter("foobarbaz.txt", true);
		try {
			String newline = System.getProperty("line.separator");
			fw.write(input + newline);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			fw.close();
		}
	}

	public int readInput() throws IOException {
		Scanner scan = new Scanner(System.in);
		int num;
		try {
			while (true) {
				try {
					System.out
							.println("Please enter a positive integer. Enter stop to exit:");
					String input = scan.nextLine();
					// fw = new FileWriter("foobarbaz.txt", false);
					if (input.equals("stop")) {
						System.out.println("Game ended!");
						return 0;
					} else {
						num = (int) Integer.parseInt(input);
						return num;
					}
				}

				catch (NumberFormatException ne) {
					System.out.println("Invalid Input");
				} catch (Exception e) {
					System.out.println("Error Occurred " + e.getMessage());
				}

			}
		} finally {
			scan.close();
			// fw.close();
		}

	}

	// This method takes input at runtime and returns appropriate stmt.

	public String fooBarBazInput(int n) throws Exception {
		String finalString = "";
		try {
			fw = new FileWriter("foobarbaz.txt", false);

			if (n == 0) {
				return "Game Ended!";
			} else if (n < 0) {
				System.out.println("Please enter a positive number");
				readInput();
			} else {

				for (int i = 1; i <= n; i++) {
					StringBuilder outputString = new StringBuilder();

					if (i % 3 == 0) {
						outputString.append(foo);
					}
					if (i % 5 == 0) {
						outputString.append(bar);
					}

					if (i % 7 == 0) {
						outputString.append(baz);
					}
					if (i % 3 != 0 && i % 5 != 0 && i % 7 != 0) {
						outputString.append(i);
					}

					finalString = outputString.toString();
					writeFile(finalString);
					System.out.println(outputString);
				}
			}

		} catch (Exception e) {
			System.out.println("Error Occurred " + e.getMessage());
		} finally {
			fw.close();
		}
		return finalString;

	}
	

}
