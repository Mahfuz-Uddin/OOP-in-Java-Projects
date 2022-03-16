package Project;

import javax.swing.JOptionPane;

/**
 * @author Mahfuz Uddin
 * @since 9/24/2020
 * @version Project 0
 * @description "The program will examine each letter in the string and count
 *              how many time the upper-case letter 'E' appears, and how many
 *              times the lower-case letter 'e' appears"
 */
public class Project0 {
	public static void main(String[] args) {

		String input = JOptionPane.showInputDialog("Enter a sentence: ");
		countAmount(input);
	}

	/**
	 * @param userInput, takes the input of the user
	 * @description Iterates through the input of the user and counts the amount of
	 *              times capital letter "E" and lower case letter "e" appear and
	 *              displays the count of each
	 */
	public static void countAmount(String userInput) {
		int count_e = 0, count_E = 0;
		// While loop runs program until user enters "stop"(not case sensitive)
		while (!userInput.equalsIgnoreCase("STOP")) {
			// Loop iterates through each character of the string
			for (int i = 0; i < userInput.length(); i++) {
				// Checks if character is either e or E and updates the count of each by 1
				if (userInput.charAt(i) == 'e')
					count_e++;
				else if (userInput.charAt(i) == 'E')
					count_E++;
			}
			//Displays the count of letter 'e' and 'E'
			JOptionPane.showMessageDialog(null,
					"Number of lower case e's : " + count_e + "\n" + "Number of upper case E's: " + count_E);
			//We reset the count to 0 because we don't want to keep adding the previous amounts
			count_e = 0;
			count_E = 0;
			userInput = JOptionPane.showInputDialog("Enter a sentence: ");
		}
	}
}