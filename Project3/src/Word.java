public class Word {

	String word;

	Word(String wordString) {
		if(Project3.validation(wordString)==false)
			throw new IllegalWordException("not valid");
			
		this.word = wordString;

	}
}
