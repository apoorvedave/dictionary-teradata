package teradata;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestCode {

	public static void main(String[] args) {
		Dictionary dict = new Trie();
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\n");

		while (true) {
			System.out.println("\nWhat would you like to do?\n1. Insert New Definition?\n2: Display all with prefix?\n"
					+ "3: Get Definition?\n4: Delete Existing Word?\n0: Exit?");
			System.out.println("\nYour Choice (1-4): ");
			int i = 0;

			try {
				i = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Try Again...");
				scan.next();
				continue;
			}

			switch (i) {
			case 0:
				scan.close();
				System.out.println("Bye");
				return;
			case 1:
				System.out.println("Enter word:");
				String word = scan.next();
				System.out.println("Enter Definition:");
				String def = scan.next();
				dict.insert(word, def);
				System.out.println("Definition Stored. Press Enter to continue...");
				word = scan.next();
				break;
			case 2:
				System.out.println("Enter prefix:");
				word = scan.next();
				System.out.print("Words with given prefix are: ");
				System.out.println(Arrays.toString(dict.getWordsWithPrefix(word)));
				System.out.println("Press Enter to continue...");
				word = scan.next();
				break;
			case 3:
				System.out.println("Enter word:");
				word = scan.next();
				System.out.print("Definition: ");
				System.out.println(dict.getDefinition(word));
				System.out.println("Press Enter to continue...");
				word = scan.next();
				break;
			case 4:
				System.out.println("Enter word:");
				word = scan.next();
				dict.delete(word);
				System.out.println("Word " + word + " deleted (if present)");
				System.out.println("Press Enter to continue...");
				word = scan.next();
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		}
	}
}
