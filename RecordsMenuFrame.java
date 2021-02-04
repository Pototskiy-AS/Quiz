package test.quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordsMenuFrame extends JFrame implements ActionListener {
    private final JFrame frame;
    private String name1, name2, name3, name4, name5, score1, score2, score3, score4, score5;
    private final JButton buttonToMenu = new JButton();

    public RecordsMenuFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

        JLabel header = new JLabel("Records");


        JLabel rec1 = new JLabel(name1 + " :                              " + score1);
        JLabel rec2 = new JLabel(name2 + " :                              " + score2);
        JLabel rec3 = new JLabel(name3 + " :                              " + score3);
        JLabel rec4 = new JLabel(name4 + " :                              " + score4);
        JLabel rec5 = new JLabel(name5 + " :                              " + score5);

        JLabel[] names = {rec1, rec2, rec3, rec4, rec5};

        int y = 30;
        for (JLabel j : names) {
            j.setBounds(50, y += 75, 300, 75);
            j.setFont(new Font("Courier", Font.BOLD, 20));
            j.setVisible(true);

            j.setBackground(new Color(234, 118, 118));
            j.setForeground(new Color(219, 206, 206));
            frame.add(j);
        }
        header.setBounds(250, 25, 300, 50);
        header.setFont(new Font("Courier", Font.BOLD, 35));
        header.setVisible(true);
        header.setBackground(new Color(234, 118, 118));
        header.setForeground(new Color(219, 206, 206));
        frame.add(header);

        buttonToMenu.setBounds(225, 550, 200, 50);
        buttonToMenu.setFont(new Font("Ink Free", Font.BOLD, 25));
        buttonToMenu.setFocusable(false);
        buttonToMenu.addActionListener(this);
        buttonToMenu.setText("Back to Menu");
        buttonToMenu.setBackground(new Color(170, 66, 66));
        buttonToMenu.setForeground(new Color(219, 206, 206));
        buttonToMenu.setEnabled(true);
        buttonToMenu.setVisible(true);

        frame.add(buttonToMenu);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonToMenu) {
            frame.dispose();
            MainMenuFrame gameFrame = new MainMenuFrame();
        }


    }
}
