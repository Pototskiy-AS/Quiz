package test.quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SettingsFrame extends JFrame implements ActionListener {
    private final Settings settings = new Settings();
    private final JFrame frame = new JFrame();

    private final   JButton saveButton;
    private final   JTextField textField = new JTextField();

    private final   JComboBox<? extends String> themeChoose;
    private final   JComboBox<? extends String> questionsCountChoose;

    public SettingsFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);


        //определить перечень тем
        String[] themes = {"SPORT", "SCIENCE", "JAVA"};
        themeChoose = new JComboBox<>(themes);
        themeChoose.setBounds(300, 200, 300, 50);
        themeChoose.addActionListener(this);
        themeChoose.setSelectedIndex(0);
        themeChoose.setVisible(true);

        //определить кол-во вопросов
        String[] count = {"5", "10", "15"};
        questionsCountChoose = new JComboBox<>(count);
        questionsCountChoose.setBounds(300, 300, 300, 50);
        questionsCountChoose.addActionListener(this);
        questionsCountChoose.setSelectedIndex(0);
        questionsCountChoose.setVisible(true);


        JTextArea text = new JTextArea("Write Your name");
        JTextArea text2 = new JTextArea("Theme");
        JTextArea text3 = new JTextArea("Questions Count");
        JTextArea[] jTextAreas = {text, text2, text3};
        for (JTextArea j : jTextAreas) {
            j.setFont(new Font("Courier", Font.BOLD, 20));
            j.setVisible(true);
            j.setFont(new Font("Courier", Font.BOLD, 20));
            j.setAlignmentX(JTextField.CENTER);
            j.setBackground(new Color(50, 50, 50));
            j.setForeground(new Color(219, 206, 206));
            j.setCaretColor(Color.white);
            j.setEditable(false);
            frame.add(j);
        }


        text.setBounds(50, 100, 300, 100);
        text2.setBounds(50, 200, 300, 100);
        text3.setBounds(50, 300, 300, 100);


        textField.setBounds(300, 100, 300, 50);
        textField.setFont(new Font("Courier", Font.BOLD, 35));
        textField.setBackground(new Color(219, 206, 206));
        textField.setForeground(new Color(95, 51, 51));
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setFont(new Font("Consolas", Font.PLAIN, 35));
        textField.setForeground(new Color(219, 206, 206));
        textField.setBackground(Color.black);
        textField.setCaretColor(Color.white);

        saveButton = new JButton("Save and exit");
        saveButton.setBounds(250, 500, 200, 100);
        saveButton.setFont(new Font("Courier", Font.BOLD, 15));
        saveButton.setFocusable(false);
        saveButton.addActionListener(this);

        frame.add(textField);
        frame.add(themeChoose);
        frame.add(questionsCountChoose);
        frame.add(saveButton);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == themeChoose) {
            if (Objects.requireNonNull(themeChoose.getSelectedItem()).equals("JAVA"))
                settings.setFileQuestion("D:\\JAVA\\JAVA\\src\\test\\quiz\\questions\\questions.json");
            if (themeChoose.getSelectedItem().equals("SCIENCE"))
                settings.setFileQuestion("D:\\JAVA\\JAVA\\src\\test\\quiz\\questions\\questions.json");
            if (themeChoose.getSelectedItem().equals("SPORT"))
                settings.setFileQuestion("D:\\JAVA\\JAVA\\src\\test\\quiz\\questions\\questions.json");
            // сохраняем в файл наш выбор темы
        }
        if (e.getSource() == questionsCountChoose) {
            // сохраняем в файл наш выбор темы
            settings.setTotal_questions(Integer.parseInt(Objects.requireNonNull(questionsCountChoose.getSelectedItem()).toString()));
        }
        if (e.getSource() == saveButton) {
            // сохраняем в файл наш выбор имени  и го в меню
            frame.dispose();
            settings.setName(textField.getText());
            Settings.settingsWriter(settings); //сохраняем настройки в settings.json
            MainMenuFrame mainMenuFrame = new MainMenuFrame();
        }

    }


}

