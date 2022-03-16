import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class EditMenuHandler implements ActionListener {

    WordGUI wordGui;

    public EditMenuHandler(WordGUI wordGui) {
        this.wordGui = wordGui;
    }
    //Here we try to search the word if it exists in the treeMap or not 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String word = JOptionPane.showInputDialog(wordGui, "Enter a word to search", "Search", JOptionPane.QUESTION_MESSAGE);
        boolean found = wordGui.search(word);
        if (found) {
            JOptionPane.showMessageDialog(wordGui, word + " is in the TreeMap", "Search", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(wordGui, word + " is not in the TreeMap", "Search", JOptionPane.ERROR_MESSAGE);
        }
    }

}
