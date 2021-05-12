import javax.swing.*;
import java.awt.*;

public class WindowCreator {

    public WindowCreator() {
        createWindow();
    }
    /**
     * Method used for creating the GUI window of the program.
     */
    private static void createWindow() {
        JFrame window = new JFrame("Isolation Calculator");
       // window.setPreferredSize(new Dimension(1024, 576));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createLayout(window.getContentPane());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    /**
     * Method used for creating the layout for the program window
     * @param window The main window of the program
     */
    private static void createLayout(Container window) {

        JPanel labels = new JPanel();
        JPanel inputLines = new JPanel();
        JPanel buttons = new JPanel();

        window.setLayout(new BoxLayout(window, BoxLayout.PAGE_AXIS));
        labels.setLayout(new BoxLayout(labels, BoxLayout.LINE_AXIS));
        inputLines.setLayout(new BoxLayout(inputLines, BoxLayout.LINE_AXIS));
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));

        thicknessLabel(labels);
        labels.add(Box.createHorizontalGlue());
        areaLabel(labels);
        inputLines(inputLines);
        addButton(buttons,inputLines);

        window.add(Box.createRigidArea(new Dimension(0,30)));
        window.add(labels);
        window.add(Box.createRigidArea(new Dimension(0,30)));
        window.add(inputLines);
        window.add(Box.createRigidArea(new Dimension(0,30)));
        window.add(buttons);
        window.add(Box.createRigidArea(new Dimension(0,30)));

    }

    /**
     * Method used for adding thickness label to the program window.
     * @param window The container
     */
    private static void thicknessLabel(Container window) {
        JLabel label = new JLabel("Ange önskad tjocklek (cm)", SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(300,100));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        window.add(label);
    }

    /**
     * Method used for adding area label to the program window.
     * @param window The container
     */
    private static void areaLabel(Container window) {
        JLabel label = new JLabel("Ange Area (m2)", SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(300,100));
        label.setAlignmentX(Component.RIGHT_ALIGNMENT);
        window.add(label);
    }

    /**
     * Method used for adding the calculation button and the listener of it.
     * @param window Container to add the button to.
     * @param text The text string to add calculation info for the listener.
     */
    private static void addButton(Container window, Container text) {
        JButton button = new JButton("Beräkna");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(e -> {

            Calculator calc = new Calculator();
            JTextField t1 = (JTextField) text.getComponent(1);
            JTextField t2 = (JTextField) text.getComponent(5);
            calc.setExpectedThickness(Integer.parseInt(t1.getText()));
            calc.setExpectedArea(Integer.parseInt(t2.getText()));
            resultPopup(calc, window);
        });
        window.add(button);
    }

    /**
     * Method used for creating the input portion of the main window.
     * @param window The container.
     */
    private static void inputLines(Container window) {
        JTextField thickness = new JTextField();
        JTextField area = new JTextField();

        window.add(Box.createRigidArea(new Dimension(30,0)));
        window.add(thickness);
        window.add(Box.createHorizontalGlue());
        window.add(Box.createRigidArea(new Dimension(30,0)));
        window.add(Box.createHorizontalGlue());
        window.add(area);
        window.add(Box.createRigidArea(new Dimension(30,0)));
    }

    /**
     * Temporary method used to show the correct calculations.
     * @param calc Calculator used to calculate the results.
     * @param window The main container of the program.
     */
    public static void resultPopup (Calculator calc, Container window) {
        String string =  "Beräknad materialåtgång: " + calc.averageMaterialConsumption() + "l. \n" +
                         "Beräknad total kostnad: " + calc.calculateCost() + "kr. \n"+
                         "Material:" + calc.getmCost() + "kr/kvm. \n" +
                         "Ställkostnad" + calc.getSetupCost() + "kr.";
        JOptionPane.showMessageDialog(window, string);

    }
}
