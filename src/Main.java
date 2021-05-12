import javax.swing.*;

/**
 * Main class for the program.
 */
public class Main {
    public static void main(String [] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            WindowCreator window = new WindowCreator();
        }
    });
    }
}
