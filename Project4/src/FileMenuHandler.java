import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileMenuHandler implements ActionListener {
	WordGUI jframe;

	public FileMenuHandler(WordGUI jf) {
		jframe = jf;
	}

	/**
	 * @description When an event occurs this method is called. When Open is clicked
	 *              the function fileExplorer is called and when Quit is called we
	 *              exit the GUI
	 */

	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		if (menuName.equals("Open"))
			fileExplorer();
		else if (menuName.equals("Quit"))
			System.exit(0);
	} // actionPerformed

	/**
	 * @description This function is called when user clicks Open. This function
	 *              opens the file chooser and user selects a text file. When the
	 *              file is chosen this function reads through the file and adds the
	 *              words to distinct array list accordingly.
	 */

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

				while (token.hasMoreTokens()) {
					word = token.nextToken();
					Project4.unsortedList.add(new Word(word));
					Project4.treeMap.put(new Word(word), "");
				}

				line = in.readLine();
			}

			jframe.createGUI();
			jframe.displayList(Project4.unsortedList, Project4.treeMap);

		} else {
			JOptionPane.showMessageDialog(null, "Canceled");
		}

	}
}