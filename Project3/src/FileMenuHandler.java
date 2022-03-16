import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileMenuHandler implements ActionListener {
	WordGUI jframe;

	public FileMenuHandler(WordGUI jf) {
		jframe = jf;
	}

	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		if (menuName.equals("Open"))
			fileExplorer();
		else if (menuName.equals("Quit"))
			System.exit(0);
	} // actionPerformed

	void fileExplorer() {
		JFileChooser fc = new JFileChooser();
		int mode = fc.showOpenDialog(null);
		if (mode == JFileChooser.APPROVE_OPTION) {

			String myFile = fc.getSelectedFile().getName();
			String line;
			TextFileInput in = new TextFileInput(myFile);
			line = in.readLine();
			StringTokenizer token = new StringTokenizer(line);

			while (line != null) {
				token = new StringTokenizer(line);
				String word = "";
				try {
					while (token.hasMoreTokens()) {
						word = token.nextToken();
						Project3.unsortedList.add(new Word(word));
						Project3.sortedList.add(new Word(word));
					}
				}

				catch (IllegalWordException e) {

					Project3.erroneousList.add(word);
				}

				line = in.readLine();
			}

			Collections.sort(Project3.sortedList, new Comparator<Word>() {
				public int compare(Word word1, Word word2) {
					return String.valueOf(word1.word).compareTo(word2.word);
				}
			});
			jframe.createGUI();
			jframe.displayList(Project3.unsortedList, Project3.sortedList, Project3.erroneousList);

		} else {
			JOptionPane.showMessageDialog(null, "Canceled");
		}

	}
}