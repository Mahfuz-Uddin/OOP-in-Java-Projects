import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * 
 * @description Controls what happens with the edit button
 *
 */
public class EditMenuHandler implements ActionListener {
	WordGUI jframe;

	public EditMenuHandler(WordGUI jf) {
		jframe = jf;
	}

	/**
	 * @description calls the function doThis() when Search is clicked otherwise it
	 *              exits
	 */
	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		if (menuName.equals("Search"))
			doThis();
		else
			System.exit(0);
	} // actionPerformed

	/**
	 * controls the functionality of the edit button
	 */
	private void doThis() {
		JOptionPane.showMessageDialog(null,
				"Make sure to populate the GUI first by first selecting a text file. Select 'File' and choose a text file");
		String input = JOptionPane.showInputDialog("Enter something to search for: ");
		Word word = new Word(input);
		while (!input.equalsIgnoreCase("STOP")) {
			if (Project4.treeMap.containsKey(word)) {
				JOptionPane.showMessageDialog(null, "The string '" + input + "' does exist");
			} else {
				JOptionPane.showMessageDialog(null, "The string '" + input + "' does  NOT exist");
			}

			input = JOptionPane.showInputDialog("Enter something to search for: ");
			word = new Word(input);
		}
	}// doThis
}
