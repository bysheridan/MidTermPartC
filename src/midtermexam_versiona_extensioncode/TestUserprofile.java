package midtermexam_versiona_extensioncode;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Brandon Yaeck, March 8 2023
 */
public class TestUserprofile {
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		String userID = "";
		int genreChoice = 0;


		System.out.println("Creating new user profile.");
		System.out.println("Please enter your name: ");
		while (true) {
			try {
				userID = keyboard.nextLine();
				if (userID == null || ! (userID.matches(".+"))) {
					throw new IllegalArgumentException("Error: Name cannot be empty.");
				} else {
					break;
				}
			}
			catch (InputMismatchException exception) {
				System.out.printf("ERROR: Value must be a string.\n");				
			}
			catch (IllegalArgumentException exception) {
				System.out.printf("%s\n", exception.getMessage());
			}
		}

		System.out.println("Please choose your favourite genre from the following list: ");
		for (int i = 0; i < UserProfile.genres.length; i++) {
			System.out.println(i + ") " + UserProfile.genres[i]);
		}


		while (true) {
			try {
				genreChoice = Integer.parseInt(keyboard.nextLine());
				if (genreChoice > UserProfile.genres.length - 1 || genreChoice < 0) {
					throw new IllegalArgumentException("Error: You must choose a genre from the list.");
				} else {
					break;
				}
			}
			catch (NumberFormatException | InputMismatchException exception) {
				System.out.printf("ERROR: Value must be an integer.\n");
			}
			catch (IllegalArgumentException exception) {
				System.out.printf("%s\n", exception.getMessage());
			}
		}


		UserProfile user = new UserProfile(userID, UserProfile.genres[genreChoice]);

		System.out.println("Your user profile has been created.");
		System.out.println("Name: " + user.getUserID());
		System.out.println("Favourite Genre: " + user.getGenre());
	}
	
}
