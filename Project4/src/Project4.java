import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author Mahfuz Uddin
 * @since 12/1/20
 * @version Project 4
 * @description The project opens a chosen file and displays the unsorted Words
 *              on the left and the sorted Words on the right. we use arrayList
 *              for unsorted words and treemap for sorted words.
 */

public class Project4 {
	public static WordGUI myGUI;
	static ArrayList<Word> unsortedList = new ArrayList<Word>();// arrayList
	static TreeMap<Word, String> treeMap = new TreeMap<>();// treemap

	public static void main(String[] args) {

		myGUI = new WordGUI();
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
	}

}
