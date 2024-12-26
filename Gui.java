import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import static javax.swing.text.StyleConstants.setIcon;

public class Gui implements ActionListener {
    private JFrame frame;
    private int frame_width;
    private int frame_height;
    private String frame_title;
    private JButton btnRed;
    private JButton btnGreen;
    private JButton btnBlue;
    private JButton btnSurf;
    private JButton btnPaint;
    private JButton btnBox;
    private JLabel lblOutput;
    private ImageIcon imageIcon;
    private JLabel surfLabel;
    private JLabel paintLabel;
    private JLabel boxLabel;
    private JPanel btnPanel;
    private JPanel iconBtnPanel;
    private JLabel lblThirdOutput;

    // Default Constructor for Main window
    public Gui(int xPos, int yPos, int frame_width,  int frame_height, String frame_title, int onCloseBehaviour) {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(frame_width, frame_height));
        //frame.setLocationRelativeTo(null);
        frame.setTitle(frame_title);
        frame.setDefaultCloseOperation(onCloseBehaviour);

        frame.setBounds(xPos, yPos, frame_width, frame_height);
        frame.setVisible(true);

        btnPanel = new JPanel();
        lblOutput = new JLabel();
        btnPanel.add(lblOutput);
        frame.add(btnPanel);
    }

    // Constructor for sub windows
    public Gui(int xPos, int yPos, int frame_width,  int frame_height, String frame_title, int onCloseBehaviour, Gui parentObject) {
        frame = new JFrame();
        frame.setLocationRelativeTo(parentObject.getFrame());
        frame.setBounds(xPos, yPos, frame_width, frame_height);
        frame.setPreferredSize(new Dimension(frame_width, frame_height));
        frame.setTitle(frame_title);
        frame.setDefaultCloseOperation(onCloseBehaviour);
        frame.setVisible(true);

        btnPanel = new JPanel();
        iconBtnPanel = new JPanel();
        lblOutput = new JLabel();
        btnPanel.add(lblOutput);
    }

    public void createButton(String color) {
        switch (color) {
            case "red":
                btnRed = new JButton("Red");
                btnRed.setBackground(Color.RED);
                btnRed.setActionCommand("redbtn");
                btnRed.addActionListener(this);
                btnPanel.add(btnRed);
                break;
            case "green":
                btnGreen = new JButton("Green");
                btnGreen.setBackground(Color.GREEN);
                btnGreen.setActionCommand("greenbtn");
                btnGreen.addActionListener(this);
                btnPanel.add(btnGreen);
                break;
            case "blue":
                btnBlue = new JButton("Blue");
                btnBlue.setBackground(Color.BLUE);
                btnBlue.setActionCommand("bluebtn");
                btnBlue.addActionListener(this);
                btnPanel.add(btnBlue);
                frame.add(btnPanel);
                break;

            default:
                System.out.println("No valid color selected");
                break;
        }
        // Add panel to frame
        frame.add(btnPanel);
        frame.pack();
    }

    // Create Icon buttons
    public void CreateIconButtons(String type, Frame frame) {
        switch (type) {
            case "Surfa":
                btnSurf = new JButton("Surfa");
                btnSurf.setActionCommand("surfbtn");
                btnSurf.addActionListener(this);
                iconBtnPanel.add(btnSurf);
                break;
            case "Måla":
                btnPaint = new JButton("Måla");
                btnPaint.setActionCommand("paintbtn");
                btnPaint.addActionListener(this);
                iconBtnPanel.add(btnPaint);
                break;
            case "Låda":
                btnBox = new JButton("Låda");
                btnBox.setActionCommand("boxbtn");
                btnBox.addActionListener(this);
                iconBtnPanel.add(btnBox);
                frame.add(iconBtnPanel);
                break;

            default:
                System.out.println("No valid value selected");
                break;
        }
        // Add panel to frame
        frame.add(iconBtnPanel);
        frame.pack();
    }

    // Third window initializer
    public void createElementsForThirdWindow(JFrame thirdFrame) {
        JPanel thirdPanel = new JPanel();
        thirdFrame.add(thirdPanel);
        JLabel lblThirdHeader = new JLabel("Skriv något tänkvärt:");
        thirdPanel.add(lblThirdHeader);
        JTextField txtField = new JTextField(20);
        txtField.addActionListener(new ActionListener() {

            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = txtField.getText();
                outputInput(text);
            }
        });
        thirdPanel.add(txtField);
        lblThirdOutput = new JLabel();
        thirdPanel.add(lblThirdOutput);
        thirdFrame.pack();
    }

    private void outputInput(String text) {
        lblThirdOutput.setText("Du skrev: " + text);
    }

    // Getters & Setters

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "redbtn":
                lblOutput.setText("Red");
                break;
            case "greenbtn":
                lblOutput.setText("Green");
                break;
            case "bluebtn":
                lblOutput.setText("Blue");
                break;
            case "surfbtn":
                imageIcon = new ImageIcon(Gui.class.getResource("/resources/surfing.gif"));
                surfLabel = new JLabel(imageIcon);
                iconBtnPanel.add(surfLabel);
                if (paintLabel != null) {
                    paintLabel.setVisible(false);
                }
                if (boxLabel != null) {
                    boxLabel.setVisible(false);
                }
                surfLabel.setVisible(true);
                frame.pack();
                break;
            case "paintbtn":
                imageIcon = new ImageIcon(Gui.class.getResource("/resources/painting.gif"));
                paintLabel = new JLabel(imageIcon);
                iconBtnPanel.add(paintLabel);
                if (boxLabel != null) {
                    boxLabel.setVisible(false);
                }
                if (surfLabel != null) {
                    surfLabel.setVisible(false);
                }
                paintLabel.setVisible(true);
                frame.pack();
                break;
            case "boxbtn":
                imageIcon = new ImageIcon(Gui.class.getResource("/resources/box.gif"));
                boxLabel = new JLabel(imageIcon);
                iconBtnPanel.add(boxLabel);
                if (surfLabel != null) {
                    surfLabel.setVisible(false);
                }
                if (paintLabel != null) {
                    paintLabel.setVisible(false);
                }
                boxLabel.setVisible(true);
                frame.pack();
                break;
            default:
                lblOutput.setText("No color/image");
                break;
        }
    }
}
