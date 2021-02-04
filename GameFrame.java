package test.quiz;
// ---------------------------- Main ----------------------------

// ---------------------------- Quiz ----------------------------

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.List;

public class GameFrame implements ActionListener {
    private final Settings settings = Settings.readSettings();
    private final Question[] questions = randomQuestions();


    private String answer;
    private int index;
    private int correct_guesses = 0;
    private int seconds = settings.getSeconds();

    private final JFrame frame = new JFrame();
    private final JTextField textField = new JTextField();
    private final JTextArea textarea = new JTextArea();
    private final JButton buttonA = new JButton();
    private final JButton buttonB = new JButton();
    private final JButton buttonC = new JButton();
    private final JButton buttonD = new JButton();
    private final JButton buttonRepeat = new JButton();
    private final JButton buttonToMenu = new JButton();
    private final JLabel answer_labelA = new JLabel();
    private final JLabel answer_labelB = new JLabel();
    private final JLabel answer_labelC = new JLabel();
    private final JLabel answer_labelD = new JLabel();
    private final JLabel seconds_left = new JLabel();
    private final JTextField number_right = new JTextField();
    private final JTextField percentage = new JTextField();

    private final Timer timer = new Timer(1000, e -> {
        seconds--;
        seconds_left.setText(String.valueOf(seconds));
        if (seconds <= 0) {
            displayAnswer();
        }
    });

    private Question[] randomQuestions() {
        Random random = new Random();
        List<Question> allQuestions = settings.questionReader();
        Set<Question> questions = new HashSet<>();
        while (questions.size() < settings.getTotal_questions()) {
            questions.add(allQuestions.get(random.nextInt(settings.getTotal_questions())));
        }
        return questions.toArray(new Question[0]);
    }

    public GameFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);

        textField.setBounds(0, 0, 650, 50);
        textField.setBackground(new Color(234, 69, 69));
        textField.setForeground(new Color(219, 206, 206));
        textField.setFont(new Font("Ink Free", Font.BOLD, 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        textarea.setBounds(0, 50, 650, 50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(170, 66, 66));
        textarea.setForeground(new Color(219, 206, 206));
        textarea.setFont(new Font("Courier", Font.BOLD, 25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);

        buttonA.setBounds(0, 100, 100, 100);
        buttonA.setFont(new Font("Courier", Font.BOLD, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0, 200, 100, 100);
        buttonB.setFont(new Font("Courier", Font.BOLD, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0, 300, 100, 100);
        buttonC.setFont(new Font("Courier", Font.BOLD, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0, 400, 100, 100);
        buttonD.setFont(new Font("Courier", Font.BOLD, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        buttonRepeat.setBounds(225, 490, 200, 50);
        buttonRepeat.setFont(new Font("Ink Free", Font.BOLD, 25));
        buttonRepeat.setFocusable(false);
        buttonRepeat.addActionListener(this);
        buttonRepeat.setText("Repeat");
        buttonRepeat.setBackground(new Color(170, 66, 66));
        buttonRepeat.setForeground(new Color(219, 206, 206));

        buttonToMenu.setBounds(225, 550, 200, 50);
        buttonToMenu.setFont(new Font("Ink Free", Font.BOLD, 25));
        buttonToMenu.setFocusable(false);
        buttonToMenu.addActionListener(this);
        buttonToMenu.setText("Back to Menu");
        buttonToMenu.setBackground(new Color(170, 66, 66));
        buttonToMenu.setForeground(new Color(219, 206, 206));


        answer_labelA.setBounds(125, 100, 500, 100);
        answer_labelA.setBackground(new Color(50, 50, 50));
        answer_labelA.setForeground(new Color(219, 206, 206));
        answer_labelA.setFont(new Font("Courier", Font.PLAIN, 35));

        answer_labelB.setBounds(125, 200, 500, 100);
        answer_labelB.setBackground(new Color(50, 50, 50));
        answer_labelB.setForeground(new Color(219, 206, 206));
        answer_labelB.setFont(new Font("Courier", Font.PLAIN, 35));

        answer_labelC.setBounds(125, 300, 500, 100);
        answer_labelC.setBackground(new Color(50, 50, 50));
        answer_labelC.setForeground(new Color(219, 206, 206));
        answer_labelC.setFont(new Font("Courier", Font.PLAIN, 35));

        answer_labelD.setBounds(125, 400, 500, 100);
        answer_labelD.setBackground(new Color(50, 50, 50));
        answer_labelD.setForeground(new Color(219, 206, 206));
        answer_labelD.setFont(new Font("Courier", Font.PLAIN, 35));

        seconds_left.setBounds(535, 510, 100, 100);
        seconds_left.setBackground(new Color(25, 25, 25));
        seconds_left.setForeground(new Color(255, 0, 0));
        seconds_left.setFont(new Font("Ink Free", Font.BOLD, 60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        JLabel time_label = new JLabel();
        time_label.setBounds(535, 475, 100, 25);
        time_label.setBackground(new Color(50, 50, 50));
        time_label.setForeground(new Color(255, 0, 0));
        time_label.setFont(new Font("MV Boli", Font.PLAIN, 16));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("timer >:D");

        number_right.setBounds(225, 225, 200, 100);
        number_right.setBackground(new Color(219, 206, 206));
        number_right.setForeground(new Color(234, 69, 69));
        number_right.setFont(new Font("Ink Free", Font.BOLD, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(225, 325, 200, 100);
        percentage.setBackground(new Color(234, 69, 69));
        percentage.setForeground(new Color(219, 206, 206));
        percentage.setFont(new Font("Ink Free", Font.BOLD, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(buttonRepeat);
        frame.add(buttonToMenu);
        frame.add(textarea);
        frame.add(textField);
        frame.setVisible(true);

        buttonToMenu.setEnabled(false);
        buttonRepeat.setEnabled(false);
        buttonRepeat.setVisible(false);
        buttonToMenu.setVisible(false);

        nextQuestion();
    }

    private void nextQuestion() {

        if (index >= settings.getTotal_questions()) {
            results();
        } else {
            textField.setText("Question " + (index + 1));
            textarea.setText(questions[index].getQuestion());
            answer_labelA.setText(questions[index].getAnswerOptions()[0]);
            answer_labelB.setText(questions[index].getAnswerOptions()[1]);
            answer_labelC.setText(questions[index].getAnswerOptions()[2]);
            answer_labelD.setText(questions[index].getAnswerOptions()[3]);
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource() == buttonA) {
            answer = "A";
            if (answer.equals(questions[index].getCorrectAnswer())) {
                correct_guesses++;
            }
            displayAnswer();
        }
        if (e.getSource() == buttonB) {
            answer = "B";
            if (answer.equals(questions[index].getCorrectAnswer())) {
                correct_guesses++;
            }
            displayAnswer();
        }
        if (e.getSource() == buttonC) {
            answer = "C";
            if (answer.equals(questions[index].getCorrectAnswer())) {
                correct_guesses++;
            }
            displayAnswer();
        }
        if (e.getSource() == buttonD) {
            answer = "D";
            if (answer.equals(questions[index].getCorrectAnswer())) {
                correct_guesses++;
            }
            displayAnswer();
        }


        if (e.getSource() == buttonRepeat) {
            frame.dispose();
            GameFrame gameFrame = new GameFrame();
        }
        if (e.getSource() == buttonToMenu) {
            frame.dispose();
            MainMenuFrame mainMenuFrame = new MainMenuFrame();
        }
    }

    public void displayAnswer() {

        timer.stop();

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (!questions[index].getCorrectAnswer().equals("A"))
            answer_labelA.setForeground(new Color(255, 0, 0));
        if (!questions[index].getCorrectAnswer().equals("B"))
            answer_labelB.setForeground(new Color(255, 0, 0));
        if (!questions[index].getCorrectAnswer().equals("C"))
            answer_labelC.setForeground(new Color(255, 0, 0));
        if (!questions[index].getCorrectAnswer().equals("D"))
            answer_labelD.setForeground(new Color(255, 0, 0));

        Timer pause = new Timer(2000, e -> {

            answer_labelA.setForeground(new Color(25, 255, 0));
            answer_labelB.setForeground(new Color(25, 255, 0));
            answer_labelC.setForeground(new Color(25, 255, 0));
            answer_labelD.setForeground(new Color(25, 255, 0));

            answer = " ";
            seconds = settings.getSeconds();
            seconds_left.setText(String.valueOf(seconds));
            buttonA.setEnabled(true);
            buttonB.setEnabled(true);
            buttonC.setEnabled(true);
            buttonD.setEnabled(true);

            index++;
            nextQuestion();
        });
        pause.setRepeats(false);
        pause.start();
    }

    public void results() {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        buttonToMenu.setEnabled(true);
        buttonRepeat.setEnabled(true);
        buttonRepeat.setVisible(true);
        buttonToMenu.setVisible(true);

        int result = (int) ((correct_guesses / (double) settings.getTotal_questions()) * 100);

        textField.setText("RESULTS!");
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        number_right.setText("(" + correct_guesses + "/" + settings.getTotal_questions() + ")");
        percentage.setText(result + "%");

        frame.add(number_right);
        frame.add(percentage);

    }
}