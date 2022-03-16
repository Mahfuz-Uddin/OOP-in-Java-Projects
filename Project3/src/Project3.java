import java.util.ArrayList;

public class Project3 {
	public static WordGUI myGUI;
	static ArrayList<Word> unsortedList = new ArrayList<Word>();
	static ArrayList<Word> sortedList = new ArrayList<Word>();
	static ArrayList<String> erroneousList = new ArrayList<String>();// replace word with string

	public static void main(String[] args) {
		myGUI = new WordGUI();
	}
	
	public static boolean validation(String word) {
		for (int i = 0; i < word.length(); i++) {
			if ((Character.isLetter(word.charAt(i)) == false ))
				return false;
		}
		return true;
	}

}
