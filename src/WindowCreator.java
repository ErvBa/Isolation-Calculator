import javax.swing.*;
import java.awt.*;

public class WindowCreator {
    private static JFrame window;
    private static Box layoutBox;

    public WindowCreator() {
        createWindow();
    }
    /**
     * Method used for creating the GUI window of the program.
     */
    private static void createWindow() {
        window = new JFrame("Isolation Calculator");
        window.setPreferredSize(new Dimension(1024, 576));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addLabels();
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    /**
     *
     */
    private static void createLayoutBox() {
        layoutBox = Box.createHorizontalBox();
    }

    /**
     *
     */
    private static void addLabels() {
        JLabel thicknessLabel = new JLabel("Ange önskad tjocklek", SwingConstants.CENTER);
        thicknessLabel.setPreferredSize(new Dimension(300,100));
        window.getContentPane().add(thicknessLabel, BorderLayout.NORTH);

        JLabel areaLabel = new JLabel("Ange önskad area", SwingConstants.CENTER);
        areaLabel.setPreferredSize(new Dimension(300,100));
        window.getContentPane().add(areaLabel, BorderLayout.NORTH);
    }
}
