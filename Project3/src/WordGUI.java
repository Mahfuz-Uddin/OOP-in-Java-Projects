import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

public class WordGUI extends JFrame {

	JTextArea sortedArea;
	JTextArea unsortedArea;
	JTextArea erroneousArea;
	JLabel label1;
	ImageIcon image1;

	public WordGUI() {
		createFileMenu();

	}
	void createGUI() {
		remove(label1);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setTitle("Project 3");
		setLocation(300, 50);
		setLayout(new GridLayout(1, 3));
		unsortedArea = new JTextArea();
		sortedArea = new JTextArea();
		erroneousArea = new JTextArea();

		Container myContentPane = getContentPane();
		myContentPane.add(sortedArea);
		myContentPane.add(unsortedArea);
		myContentPane.add(erroneousArea);

		sortedArea.setEditable(false);
		unsortedArea.setEditable(false);
		erroneousArea.setEditable(false);

		unsortedArea.setBackground(Color.gray);
		sortedArea.setBackground(Color.green);
		erroneousArea.setBackground(Color.red);

		Font font = new Font("Monospaced", Font.BOLD, 15);
		unsortedArea.setFont(font);
		sortedArea.setFont(font);
		erroneousArea.setFont(font);

		JScrollPane unsortedScroll = new JScrollPane(unsortedArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		myContentPane.add(unsortedScroll);
		JScrollPane sortedScroll = new JScrollPane(sortedArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		myContentPane.add(sortedScroll);
		JScrollPane erroneousScroll = new JScrollPane(erroneousArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		myContentPane.add(erroneousScroll);
		setVisible(true);

	}// create GUI

	public void displayList(ArrayList<Word> unsortedList, ArrayList<Word> sortedList, ArrayList<String> erroneousList) {
		for (int i = 0; i < unsortedList.size(); i++) {
			this.unsortedArea.append(unsortedList.get(i).word + "\n");
		}

		for (int i = 0; i < sortedList.size(); i++) {
			this.sortedArea.append(sortedList.get(i).word + "\n");
		}

		for (int i = 0; i < erroneousList.size(); i++) {
			this.erroneousArea.append(erroneousList.get(i) + "\n");
		}

	}// displayList

	void createFileMenu() {
		setSize(500, 500);
		setTitle("Project 3");
		setLocation(300, 50);
		
		JMenuItem item;
		JMenuBar menuBar = new JMenuBar();

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
		
		
		
		image1= new ImageIcon(getClass().getResource("yoda.jpg"));
		label1= new JLabel(image1);
		add(label1);
		//pack();
		setVisible(true);
	}

}
