import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.*;

/**
 * @description Create a GUI to display the arrayList using a GridLayout with
 *              one row and three columns
 */

public class WordGUI extends JFrame {

	JTextArea sortedArea;
	JTextArea unsortedArea;
	JLabel label1;
	ImageIcon image1;

	public WordGUI() {
		createFileMenu();

	}

	/**
	 * 
	 * @description controls how the GUI looks and all it's componenets.
	 */

	void createGUI() {
		remove(label1);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setTitle("Project 3");
		setLocation(300, 50);
		setLayout(new GridLayout(1, 3));
		unsortedArea = new JTextArea();
		sortedArea = new JTextArea();

		Container myContentPane = getContentPane();
		myContentPane.add(sortedArea);
		myContentPane.add(unsortedArea);

		sortedArea.setEditable(false);
		unsortedArea.setEditable(false);

		unsortedArea.setBackground(Color.gray);
		sortedArea.setBackground(Color.green);

		Font font = new Font("Monospaced", Font.BOLD, 15);
		unsortedArea.setFont(font);
		sortedArea.setFont(font);

		JScrollPane unsortedScroll = new JScrollPane(unsortedArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		myContentPane.add(unsortedScroll);
		JScrollPane sortedScroll = new JScrollPane(sortedArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		myContentPane.add(sortedScroll);
		setVisible(true);

	}// create GUI
	/**
	 * 
	 * @param unsortedList
	 * @param treeMap
	 * @description appends arrayList and treemap to the GUI
	 */
	public void displayList(ArrayList<Word> unsortedList, TreeMap<Word, String> treeMap) {
		for (int i = 0; i < unsortedList.size(); i++) {
			this.unsortedArea.append(unsortedList.get(i).word + "\n");
		}

		for (Word theWord : Project4.treeMap.keySet()) { // for each entry in the map's entry set
			// print it
			this.sortedArea.append(theWord.word + "\n");
		}

	}// displayList

	/**
	 * @description creates the file system in the gui for Edit and File
	 */
	void createFileMenu() {
		setSize(500, 500);
		setTitle("Project 4");
		setLocation(300, 50);

		JMenuItem item;
		JMenuBar menuBar = new JMenuBar();
		// file
		JMenu fileMenu = new JMenu("File");
		FileMenuHandler fmh = new FileMenuHandler(this);
		menuBar.setBackground(Color.BLACK);
		fileMenu.setForeground(Color.WHITE);
		Font font = new Font("Monospaced", Font.BOLD, 25);
		fileMenu.setFont(font);

		item = new JMenuItem("Open");
		item.addActionListener(fmh);
		fileMenu.add(item);

		fileMenu.addSeparator(); // add a horizontal separator line

		item = new JMenuItem("Quit");
		item.addActionListener(fmh);
		fileMenu.add(item);

		setJMenuBar(menuBar);
		menuBar.add(fileMenu);

		// edit
		JMenu editMenu = new JMenu("Edit");
		EditMenuHandler emh = new EditMenuHandler(this);
		item = new JMenuItem("Search");

		item.addActionListener(emh);
		editMenu.add(item);

		editMenu.setForeground(Color.WHITE);
		editMenu.setFont(font);
		menuBar.add(editMenu);

		image1 = new ImageIcon(getClass().getResource("yoda.jpg"));
		label1 = new JLabel(image1);
		add(label1);
		// pack();
		setVisible(true);
	}

}
