import javax.swing.*;
import java.awt.*;

/**
 * @author Mahfuz Uddin
 * @since 10/1/2020
 * @version Project 1
 * @description Create a GUI to display the arrays using a GridLayout with one
 *              row and three columns
 */
public class WordGUI {

	public void createGUI(String[] array1, String[] array2, String[] array3) {
		JFrame myFrame = new JFrame();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(700, 500);
		myFrame.setTitle("Project 1");
		myFrame.setLocation(300, 50);
		myFrame.setLayout(new GridLayout(1, 3));

		displayText(myFrame, array1, array2, array3);

		// myFrame.pack();
		myFrame.setVisible(true);
	}// createGUI

	/**
	 * 
	 * @param myFrame
	 * @param array1
	 * @param array2
	 * @param array3
	 * @description displays the arrays
	 */
	public void displayText(JFrame myFrame, String[] array1, String[] array2, String[] array3) {
		Container myContentPane = myFrame.getContentPane();

		TextArea allWords = new TextArea();
		TextArea validArea = new TextArea();
		TextArea invalidArea = new TextArea();
		allWords.setEditable(false);
		validArea.setEditable(false);
		invalidArea.setEditable(false);
		invalidArea.setBackground(Color.red);
		validArea.setBackground(Color.green);
		allWords.setBackground(Color.LIGHT_GRAY);

		myContentPane.add(allWords);
		myContentPane.add(validArea);
		myContentPane.add(invalidArea);

		int i = 0;
		// allWords.append("All the Words \n");
		while (array1[i] != null) {
			allWords.append(array1[i] + "\n");
			i++;
		}
		;
		int k = 0;
		// validArea.append("Valid Words \n");
		while (array2[k] != null) {
			validArea.append(array2[k] + "\n");
			k++;
		}
		;
		int j = 0;
		// invalidArea.append("Invalid Words \n");
		while (array3[j] != null) {
			invalidArea.append(array3[j] + "\n");
			j++;
		}
		;
	}// displayText
}
