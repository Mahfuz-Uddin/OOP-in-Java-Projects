
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

//To handle the file opening and exiting 
public class FileMenuHandler implements ActionListener {

    JFileChooser fileChooser = new JFileChooser();
    WordGUI wordGui;

    public FileMenuHandler(WordGUI wordGui) {
        this.wordGui = wordGui;
        fileChooser.setCurrentDirectory(new File("."));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int returnVal = fileChooser.showOpenDialog(wordGui);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    Word word = new Word(scanner.next());
                    System.out.println(word);
                    wordGui.addWord(word);
                }
                scanner.close();
            } catch (FileNotFoundException ex) {

            }
            

        } else {

        }
    }

}





