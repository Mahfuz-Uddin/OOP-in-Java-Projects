/**
 * 
 * @description We create a new type called word and word class constructor. we
 *              also compares words to sort them alphabetically
 */

public class Word implements Comparable<Word> {

	String word;

	Word(String wordString) {

		this.word = wordString;

	}

	public int compareTo(Word o) {
		return this.word.compareTo(o.word);
	}

}
