import java.util.*;

/**
 * @author Mahfuz Uddin
 * @since 10/1/2020
 * @version Project 1
 * @description "Read from a file that contains a paragraph of words. Put all
 *              the words in an array, put the valid words (words that have only
 *              letters) in a second array, and put the invalid words in a third
 *              array. Sort the array of valid words using Selection Sort.
 *              Create a GUI to display the arrays using a GridLayout with one
 *              row and three columns."
 */

public class Project1 {
	// initializes the program
	public static void main(String[] args) {
		String[] words = new String[1000];
		String[] validWords = new String[1000];
		String[] invalidWords = new String[1000];
		String line;
		String myFile = args[0];
		TextFileInput in = new TextFileInput(myFile);
		line = in.readLine();
		StringTokenizer token = new StringTokenizer(line);

		int i = 0;
		while (line != null) {
			token = new StringTokenizer(line);
			while (token.hasMoreTokens()) {
				words[i] = token.nextToken();
				i++;
			}
			line = in.readLine();
		}

		separation(words, validWords, invalidWords);
		int count = 0;

		// bypass java.lang.NullPointerException
		while (validWords[count] != null) {
			count++;
		}
		selectionSort(validWords, count);

		WordGUI myGUI = new WordGUI();
		myGUI.createGUI(words, validWords, invalidWords);

	}// main

	/**
	 * 
	 * @param mainArray
	 * @param validArray
	 * @param invalidArray
	 * @description Takes the strings from mainArray and checks to see if its a
	 *              valid word using validation function. If it is a valid word than
	 *              it stores it in array validArray and if it is not a valid array
	 *              it is stored in invalidArray.
	 */
	public static void separation(String[] mainArray, String[] validArray, String[] invalidArray) {
		int validCount = 0;
		int invalidCount = 0;
		int k = 0;
		while (mainArray[k] != null) {
			if ((validation(mainArray[k])) == true) {
				validArray[validCount] = mainArray[k];
				validCount++;
			} else {
				invalidArray[invalidCount] = mainArray[k];
				invalidCount++;
			}
			k++;
		}
	}

	/**
	 * 
	 * @param word
	 * @return boolean
	 * @description Checks to see if each string is a valid word or not.
	 */
	public static boolean validation(String word) {
		for (int i = 0; i < word.length(); i++) {
			if ((Character.isLetter(word.charAt(i)) == false))
				return false;
		}
		return true;
	}// validation

	/**
	 * 
	 * @param validArray
	 * @param count
	 * @description Sorts the validArray alphabetically
	 */
	public static void selectionSort(String[] validArray, int count) {
		for (int i = 0; i < count - 1; i++) {

			int minIndex = i;
			String minString = validArray[i];

			for (int j = i + 1; j < count; j++) {
				// compares Ascii values to see which is smaller/bigger
				if (validArray[j].compareToIgnoreCase(minString) < 0) {
					minString = validArray[j];
					minIndex = j;
				}
			}

			if (minIndex != i) {
				String temp = validArray[minIndex];
				validArray[minIndex] = validArray[i];
				validArray[i] = temp;
			}
		}

	}// selectionSort

}// Project1
