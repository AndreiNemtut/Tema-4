package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static final int TOTAL_QUESTIONS_NUMBER = 3;
    private static int qustionNumber = 0;
    private static int rightAnswers = 0;

    private static JRadioButton jRadioButton1;
    private static JRadioButton jRadioButton2;
    private static JRadioButton jRadioButton3;
    private static JRadioButton jRadioButton4;
    private static ButtonGroup ansersButton;
    private static JButton submitButton;

    public static void main(String[] args) {
        Questions question = Questions.QUESTION_1;
        qustionNumber++;
        JPanel panel = buildPanel(question);
        addActionToButton(panel, question);
    }

    public static void addActionToButton(JPanel panel, Questions question) {
        submitButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.updateUI();
                        String answer = null;
                        if (jRadioButton1.isSelected())
                            answer = question.getAnswer1();
                        else if (jRadioButton2.isSelected())
                            answer = question.getAnswer2();
                        else if (jRadioButton3.isSelected())
                            answer = question.getAnswer3();
                        else if (jRadioButton4.isSelected())
                            answer = question.getAnswer4();
                        if (answer == null) {
                            placeComponents(panel, question);

                            JLabel mustSelectLabel = new JLabel("* You have to select one option. *");
                            mustSelectLabel.setBounds(20, 190, 500, 25);
                            panel.add(mustSelectLabel);

                            addActionToButton(panel, question);
                        } else {
                            if (answer.equals(question.getRightAnswer()))
                                rightAnswers++;
                            if (qustionNumber < TOTAL_QUESTIONS_NUMBER) {
                                qustionNumber++;
                                placeComponents(panel, question.getNext());
                                addActionToButton(panel, question.getNext());
                            } else {
                                panel.removeAll();

                                JLabel questionNumberLabel = new JLabel("Congratulations! Yo've answered correct to " + rightAnswers + " questions.");
                                questionNumberLabel.setBounds(50, 150, 500, 25);
                                panel.add(questionNumberLabel);
                            }
                        }
                    }
                }
        );
    }

    private static JPanel buildPanel(Questions question) {
        JFrame frame = new JFrame("Insert data: ");
        frame.setSize(600, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        placeComponents(panel, question);

        frame.setVisible(true);

        return panel;
    }

    private static void placeComponents(JPanel panel, Questions question) {
        panel.removeAll();
        panel.setLayout(null);

        JLabel questionNumberLabel = new JLabel("Question: " + qustionNumber + "/" + TOTAL_QUESTIONS_NUMBER);
        questionNumberLabel.setBounds(10, 20, 80, 25);
        panel.add(questionNumberLabel);

        JLabel questionLabel = new JLabel("Q: " + question.getQuestion());
        questionLabel.setBounds(20, 80, 300, 25);
        panel.add(questionLabel);

        jRadioButton1 = new JRadioButton();
        jRadioButton1.setText(question.getAnswer1());
        jRadioButton1.setBounds(90, 100, 80, 25);
        panel.add(jRadioButton1);

        jRadioButton2 = new JRadioButton();
        jRadioButton2.setText(question.getAnswer2());
        jRadioButton2.setBounds(90, 120, 80, 25);
        panel.add(jRadioButton2);

        jRadioButton3 = new JRadioButton();
        jRadioButton3.setText(question.getAnswer3());
        jRadioButton3.setBounds(90, 140, 80, 25);
        panel.add(jRadioButton3);

        jRadioButton4 = new JRadioButton();
        jRadioButton4.setText(question.getAnswer4());
        jRadioButton4.setBounds(90, 160, 80, 25);
        panel.add(jRadioButton4);

        ansersButton = new ButtonGroup();
        ansersButton.add(jRadioButton1);
        ansersButton.add(jRadioButton2);
        ansersButton.add(jRadioButton3);
        ansersButton.add(jRadioButton4);

        submitButton = new JButton("Submit");
        submitButton.setBounds(30, 230, 150, 25);
        panel.add(submitButton);
    }

}
