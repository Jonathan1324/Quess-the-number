import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Main {

    static Integer myNumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);
    static Integer tries = 0;
    static JLabel text = new JLabel("Enter a number between 0 and 100!");
    static JTextField textField = new JTextField();
    static JLabel text2 = new JLabel("It took you 0 tries so far!");

    public static void main(String[] args) {
        openUI();
        // nextRound();
    }

    public static void openUI(){
        JFrame frame = new JFrame("Guess the number!");
        frame.setSize(400, 300);
        frame.setLocation(100, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);

        text.setBounds(50,50,300,30);

        textField.setBounds(50,100,300,30);
        text2.setBounds(10,10,300,20);

        JButton button = new JButton("Guess!");
        button.setBounds(50,150,300,30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String textFromTextfield = textField.getText();
                    Integer number = Integer.parseInt(textFromTextfield);
                    guess(number);
                    text2.setText("It took you " + tries + " tries so far!");
                } catch (Exception error) {
                    text.setText("Enter a number!");
                    textField.setText("");
                }
            }
        });

        frame.add(text2);
        frame.add(text);
        frame.add(textField);
        frame.add(button);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void guess(Integer number) {
        if(number == myNumber) {
            text.setText("Guessed correctly! with " + tries + " tries!");
            System.out.println("done in " + tries + " tries");
        } else {
            tries++;
            if(number < myNumber) {
                text.setText("Wrong guess! Your number is too small!");
            } else {
                text.setText("Wrong guess! Your number is too big!");
            }
            textField.setText("");

        }
    }


}