
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class WordGUI extends JFrame {

    TreeMap<Word, String> treemap = new TreeMap<>();
    JList<String> unsortedWords = new JList<>();
    DefaultListModel model = new DefaultListModel();
    JList<String> sortedWords = new JList<>();

    JScrollPane scrollPane1 = new JScrollPane(unsortedWords);
    JScrollPane scrollPane2 = new JScrollPane(sortedWords);
    JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
            scrollPane1, scrollPane2);

    public WordGUI(String title, int height, int width) {
        setTitle(title);
        setSize(height, width);
        setLocation(400, 200);
        createFileMenu();
        getContentPane().add(splitPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createFileMenu() {
        JMenuItem item;
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        FileMenuHandler fmh = new FileMenuHandler(this); //this refers to WordGUI

        item = new JMenuItem("Open");    //Opens File Explorer
        item.addActionListener(fmh);  //Used to listen to user actions 
        fileMenu.add(item);

        JMenu editMenu = new JMenu("Edit"); // Adds "Edit" option to menu bar
        EditMenuHandler edmh = new EditMenuHandler(this);
        item = new JMenuItem("Search");
        item.addActionListener(edmh);  // Used to listen to user actions 
        editMenu.add(item);

        item = new JMenuItem("Quit"); // Ends the program
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(item);

        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

    }

    // The following function adds words to the sorted and unsorted panels using treemap.
    public void addWord(Word word) {
        model.addElement(word.getWord());
        unsortedWords.setModel(model);
        treemap.put(word, word.getWord());
        DefaultListModel sortedModel = new DefaultListModel();
        sortedModel.addAll(treemap.values());
        sortedWords.setModel(sortedModel);
    }

    // The following boolean search function is implemented for the search feature
    public boolean search(String word) {
        for (String value : treemap.values()) {
            if (value.compareTo(word) == 0) {
                return true;
            }
        }
        return false;
    }
}
