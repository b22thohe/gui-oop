import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {
    private JFrame frame;
    private int frame_width;
    private int frame_height;
    private String frame_title;
    private JButton btnRed;
    private JButton btnGreen;
    private JButton btnBlue;
    private JLabel lblOutput;
    private JPanel btnPanel;

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
        lblOutput = new JLabel();
        btnPanel.add(lblOutput);
        frame.add(btnPanel);
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
                break;
            default:
                System.out.println("No valid color selected");
                break;

        }
        // Add panel to frame
        frame.add(btnPanel);
        frame.pack();
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
            default:
                lblOutput.setText("No color");
                break;
        }
    }
}
